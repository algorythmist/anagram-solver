package com.tecacet.anagrams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AnagramSolverTest {

    @Test
    public void testSolve() throws IOException {
        AnagramSolver solver = new AnagramSolver();
        String word = "LATE";
        Set<String> words = solver.solve(word);
        assertEquals("[LATE, TALE, TEAL]", words.toString());
    }

    @Test
    public void testSolve2() throws IOException {
        AnagramSolver solver = new AnagramSolver();
        String word = "INSANE";

        Set<String> words = solver.solve(word);
        assertEquals("[INSANE, SIENNA]", words.toString());
    }

    @Test
    public void testSolveMultipeWords() throws IOException {
        AnagramSolver solver = new AnagramSolver(true);
        String word = "SNOWMAN";
        Set<String> words = solver.solve(word);

        List<String> expected = Arrays.asList("SNOW MAN", "SOWN MAN", "SWAM NON", "NON SWAM", "MAN SOWN", "MAN SNOW");
        assertEquals(6, words.size());
        for (String e : expected) {
            assertTrue(words.contains(e));
        }

    }

    @Test
    public void testSolveUniqueWords() throws IOException {
        AnagramSolver solver = new AnagramSolver(true);
        String word = "SNOWMAN";
        Set<String> words = solver.solve(word, true);
        List<String> expected = Arrays.asList("MAN SNOW", "MAN SOWN", "NON SWAM");
        assertEquals(3, words.size());
        for (String e : expected) {
            assertTrue(words.contains(e));
        }
    }

    @Test
    public void testLowerCase() throws IOException {
        AnagramSolver solver = new AnagramSolver("english3.txt", false);
        String word = "litter";
        Set<String> words = solver.solve(word, true);
        assertEquals(3, words.size());
    }

}
