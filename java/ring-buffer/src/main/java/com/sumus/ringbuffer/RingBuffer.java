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
     * Sticks an element into the ring buffer and thus becomes the youngest element
     * @param element what to put in the ring buffer
     * @throws RingBufferIOException when an attempt is made to write to a full ring buffer
     */
    void write(T element) throws RingBufferIOException;

    /**
     * If ring buffer is full, removes oldest element in ring buffer to make room for new element inserted.
     * If buffer not full then adds element to ring buffer without over writing any element
     * @param element the element to add to ring buffer with potential removal of oldest entry to make room
     */
    void overwrite(T element);

    /**
     * Cleans out all elements from ring buffer and results in an empty ring buffer but keeping the original size
     */
    void clear();

}