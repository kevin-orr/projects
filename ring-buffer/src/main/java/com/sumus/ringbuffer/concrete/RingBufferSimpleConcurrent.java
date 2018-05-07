package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;
import com.sumus.ringbuffer.RingBufferIOException;

/**
 * Implementing this with, say ConcurrentLinkedQueue, didn't really add anything - sure most of the methods
 * are synchronized but we make use of the size() method below and for ConcurrentLinkedQueue that call
 * is built up via transversal of structure, counting up entries as we go - which would need to be blocked too
 * as entries could be inserted/removed while counting.
 *
 * @param <T> the element type to store in ring buffer
 */
final public class RingBufferSimpleConcurrent<T> implements RingBuffer<T> {

    private final RingBuffer<T> ringBuffer;

    private RingBufferSimpleConcurrent(int size) {
        ringBuffer = RingBufferAsList.create(size);
    }

    public static <T> RingBuffer<T> create(int size) {
        return new RingBufferSimpleConcurrent(size);
    }

    @Override
    public synchronized T read() throws RingBufferIOException {
        return ringBuffer.read();
    }

    @Override
    public synchronized void write(T element) throws RingBufferIOException {
        ringBuffer.write(element);
    }

    @Override
    public synchronized void overwrite(T element) {
        ringBuffer.overwrite(element);
    }

    @Override
    public synchronized void clear() {
        ringBuffer.clear();
    }
}
