# Ring Buffer

A **Ring Buffer** (also commonly referred to as a **Cyclic** or **Circular buffer**) is a data
structure that uses a **fixed-size** and **singular** buffer as if it were **connected end-to-end**.

A **Ring Buffer** starts life with a specified size <code>m</code> but with all <code>m</code> "slots" empty.

The user is not concerned about where the **Ring Buffer** starts/ends.

Once an item is added to a **Ring Buffer** it remains there until it's evicted in one of two ways:
* a read() operation pops the item from the ring which frees up a slot
* an overwrite operation forces the item out of the ring to make room for another item

When the **Ring Buffer** is full any further writes will cause an IO exception to be raised - all further writes are *blocked* until a slot becomes free.

When a **Ring Buffer** is full, the user can opt to overwrite the oldest.

## Java version

Java 8 is required



## Running the tests

To run the tests execute the following in console:

```sh
$ gradle test
```



## Source

Wikipedia [http://en.wikipedia.org/wiki/Circular_buffer](http://en.wikipedia.org/wiki/Circular_buffer)


## Exercism

Most of this readme is a rehash of the excellent [exercism open source practice problem site](http://exercism.io/exercises/java/circular-buffer/readme)
