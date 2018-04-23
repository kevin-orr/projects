package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;
import com.sumus.ringbuffer.RingBufferIOException;

public final class RingBufferFlavour {

    public static <T> RingBuffer<T> create(int size) throws RingBufferIOException {

        if (size < 0) throw new RingBufferIOException("Buffer size cannot be negative");

        return RingBufferAsList.create(size);
    }
}
