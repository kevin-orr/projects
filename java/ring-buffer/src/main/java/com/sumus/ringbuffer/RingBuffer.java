package com.sumus.ringbuffer;

/**
 * A ring buffer - fixed size and singular buffer data structure which acts as if it were connected end-to-end.
 * Insertion and removal similiar to FIFO in semantics.
 */
public interface RingBuffer<T> {

    /**
     * Removes the oldest element from the ring buffer and returns the element.
     * @return the oldest element in buffer
     * @throws RingBufferIOException when an attempt to read an empty buffer
     */
    T read() throws RingBufferIOException;

    /**
     * Sticks an element into the ring buffer - the element becomes the first in the ring buffer
     * @param element what to put in the ring buffer
     * @throws RingBufferIOException when an attempt is made to write to a full ring buffer
     */
    void write(T element) throws RingBufferIOException;

}