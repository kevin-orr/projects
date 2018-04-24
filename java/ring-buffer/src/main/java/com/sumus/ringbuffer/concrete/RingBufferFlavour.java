package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;
import com.sumus.ringbuffer.RingBufferIOException;

public final class RingBufferFlavour {

    public static <T> RingBuffer<T> create(RingBuffer.Type type, int size) throws RingBufferIOException {

        if (size < 0) throw new RingBufferIOException("Buffer size cannot be negative");

        switch (type) {
            case List:
                return RingBufferAsList.create(size);
            case Queue:
                return RingBufferAsQueue.create(size);
            default:
                return RingBufferAsList.create(size);
        }
    }
}
