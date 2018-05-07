# List Zip

We don't we have tuples in Java?
We have them in Python, Scala and even something similar in Groovy and yet we still (as of writing) don't have something
built into the language for Java.

Anyway, taking Scala as an example, on Seq, List etc. there are methods called **zip** and **zipWithIndex** which act on 
list(s) to produce a list of tuples.

## Example

For example, suppose we have the following list

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

Now consider **zipWithIndex** which zips up a list with its indices (zero based of course ;-).

## Example

Suppose we have the following list

```java
List<String> strs = Arrays.asList("one", "two", "three");

List pairs = ListZip.zipWithIndex(strs);

System.out.println(pairs.toString());

----Output------------------------------------------------------------------------------------

[Pair(Optional[one], Optional[0]), Pair(Optional[two], Optional[1]), Pair(Optional[three], Optional[2])]

```


