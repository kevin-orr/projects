package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;

import java.util.ArrayList;

final class RingBufferAsList<T> extends RingBufferPattern<T, ArrayList<T>> {

    private RingBufferAsList(int size) {
        capacity = size;
        ring = new ArrayList<T>(capacity);
    }

    public static <T> RingBuffer<T> create(int size) {
        return new RingBufferAsList(size);
    }

    @Override
    T remove() { return ring.remove(0); }

    @Override
    void cleanUp() { ring.clear(); }
}
