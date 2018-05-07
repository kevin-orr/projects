package com.sumus.ringbuffer.concrete;

import com.sumus.ringbuffer.RingBuffer;

import java.util.PriorityQueue;

final class RingBufferAsQueue<T> extends RingBufferPattern<T, PriorityQueue<T>> {

    private RingBufferAsQueue(int size) {
        capacity = size;
        ring = new PriorityQueue(capacity);
    }

    public static <T> RingBuffer<T> create(int size) {
        return new RingBufferAsQueue(size);
    }

    @Override
    T remove() { return ring.remove(); }

    @Override
    void cleanUp() { ring.clear(); }
}
