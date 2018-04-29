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

