package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;
import com.sumus.ringbuffer.RingBufferIOException;

import java.util.Collection;

abstract class RingBufferPattern<T, E extends Collection> implements RingBuffer<T> {

    protected E ring;
    protected int capacity;

    // let subclasses decide how to remove/clear
    abstract T remove();
    abstract void cleanUp();

    @Override
    public T read() throws RingBufferIOException {
        if (ring.size() == 0) throw new RingBufferIOException("Tried to read from empty buffer");
        return remove();
    }

    @Override
    public void write(T element) throws RingBufferIOException {
        if (ring.size() == capacity) throw new RingBufferIOException("Tried to write to full buffer");
        ring.add(element);
    }

    @Override
    public void overwrite(T element) {
        if (ring.size() == capacity) remove();
        ring.add(element);
    }

    @Override
    public void clear() {
        cleanUp();
    }
}
