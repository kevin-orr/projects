# [Stream Mixer](stream-mixer/)

The Stream interface has a static method **concat(firstStream, secondStream)** which creates a lazily concatenated stream whose elements are all the elements of the **firstStream** followed by all the elements of the **secondStream**. However, I wanted a
stream that would **alternate** the elements from the first and second, such as:
* first item from stream is from firstStream,
* next item from stream is from secondStream,
* next item from stream is from firstStream,
* ah, you get the idea, right?


## Example

Mixing the following IntStream's 

```java
IntStream one = IntStream.iterate(0, n -> n + 1);
IntStream two = IntStream.iterate(10, n -> n * 10);


StreamMixer.intMixer(one, two)
    .limit(10)
    .forEach(System.out::println);

```
will result in output:

```java

0
10
1
100
2
1000
3
10000
4
100000

```

Whereas, if we used Stream's concat method:

```java
IntStream one = IntStream.iterate(0, n -> n + 1).limit(5);
IntStream two = IntStream.iterate(10, n -> n * 10).limit(5);

IntStream.concat(one, two)
    .forEach(System.out::println);

```
will result in output:

```java

0
1
2
3
4
10
100
1000
10000
100000

```
