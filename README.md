# [Leap Year](leap-year/)
A simple util to determine if a given year is in fact a leap year ot not.


# [List Zip](list-zip/)
Another nice feature of Seq[A] are the [**zip, zipWithIndex**](https://www.scala-lang.org/api/current/scala/collection/Seq.html) methods which combines elements from Seq(s) into a Seq of tuples (or pairs.) So I wanted to implement something similar in Java.

# [Ring Buffer](ring-buffer/)
A simple implementation of a **Ring Buffer** or what's also known as **Circular or Cyclic Buffer**.

# [Sliding Window](sliding-window/)
Scala Seq[A] has a great method called [**sliding**](https://www.scala-lang.org/api/current/scala/collection/Seq.html) which groups elements in fixed size blocks by passing a "sliding window" over them (as opposed to partitioning them.) So I wanted to implement something similar in Java.

# [Stream Mixer](stream-mixer/)
The Stream interface has a static method **concat(firstStream, secondStream)** which creates a lazily concatenated stream whose elements are all the elements of the **firstStream** followed by all the elements of the **secondStream**. However, I wanted a
stream that would **alternate** the elements from the first and second, such as:
* first item from stream is from firstStream,
* next item from stream is from secondStream,
* next item from stream is from firstStream,
* ah, you get the idea, right?

