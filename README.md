# anagram-solver
A Java utility for finding com.tecacet.anagrams

Example:

```java
AnagramSolver solver = new AnagramSolver();
String word = "LATE";
Set<String> words = solver.solve(word);
//LATE, TALE, TEAL
```

For Multi-word anagrams:

```java
AnagramSolver solver = new AnagramSolver(true);
String word = "SNOWMAN";
Set<String> words = solver.solve(word);
//"SNOW MAN", "SOWN MAN", "SWAM NON", "NON SWAM", "MAN SOWN", "MAN SNOW"
```