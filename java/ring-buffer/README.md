# Ring Buffer

A ring buffer (also commonly referred to as a cyclic or circular buffer) is a data
structure that uses a fixed-size and singular buffer as if it were connected end-to-end.

A ring buffer starts life with a specified size <code>m</code> but with all <code>m</code> "slots" empty.

The user is not concerned about where the ring buffer starts/ends.

Once an item is added to the ring it remains there until it's evicted in one of two ways:
* a read() operation pops the item from the ring which frees up a slot
* an overwrite operation forces the item out of the ring to make room for another item

When the ring is full any further writes to the ring will cause an IO exception to be raised - all further writes are blocked until a slot becomes free.

When the buffer is full, the client can opt to overwrite the oldest.


# Running the tests

To run the tests execute the following in console:

```sh
$ gradle test
```



## Source

Wikipedia [http://en.wikipedia.org/wiki/Circular_buffer](http://en.wikipedia.org/wiki/Circular_buffer)


## Exercism

Most of this readme is a rehash of the excellent [exercism open source practice problem site](http://exercism.io/exercises/java/circular-buffer/readme)
