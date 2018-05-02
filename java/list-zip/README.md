# List Zip

We don't we have tuples in Java?
We have them in Python, Scala and even something similar in Groovy and yet we still (as of writing) don't have something
built into the language for Java.

Anyway, taking Scala as an example, on Seq, List etc. there's a method called **zip** which takes another list and cobines the two lists into
a collection of tuples, Zips up 2 list together.

## Example

Suppose we have the following list

```java
List<Integer> nums = Arrays.asList(1, 2, 3);
List<String> strs = Arrays.asList("one", "two", "three");
```

then using zip on these two lists produces the following:
 
```java

List<Pair<Integer, String>> pairs = ListZip.zip(nums, strs);

System.out.println(pairs.toString());

----Output------------------------------------------------------------------------------------

[Pair(Optional[1], Optional[one]), Pair(Optional[2], Optional[two]), Pair(Optional[3], Optional[three])]

```

