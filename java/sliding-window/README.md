# Sliding Window

Groups elements in fixed sized blocks by "sliding a window" over the elements.

## Example

Suppose we have the following list

```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
```

then passing a sliding window of size 3 over this list will result in a new list which contains the 3 lists below:

```java

List<Integer>(1, 2, 3)
List<Integer>(2, 3, 4)
List<Integer>(3, 4, 5)
```


## Sample
I've provided a very simple sample of how the sliding window can be used in **LargestProductFromString.** 

Given a string of digits, use it to calculate the largest product from sliding over string - take a look at this exercism.io 
[exercise](http://exercism.io/exercises/java/largest-series-product/readme). 
For example, what's the largest product that result when we slide over **"576802143"** with a window of size **2**?


```java

final LargestProductFromString calculator = new LargestProductFromString("576802143");

final long actualProduct = calculator.calculateLargestProductForSeriesLength(2);

assertEquals(48, actualProduct);
```
