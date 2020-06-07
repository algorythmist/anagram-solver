package com.tecacet.anagrams;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find anagrams for a given word
 *
 * @author dimitri
 */
public class AnagramSolver {

    private final DictionaryReader dictionaryReader = new DictionaryReader();
    private final Trie dictionary;
    /**
     * Look for multiple words that form an anagram of the given word
     */
    private final boolean findMultiWordAnagram;

    public AnagramSolver() throws IOException {
        this("dictionary-common.txt", false);
    }

    public AnagramSolver(boolean findMultiWordAnagram) throws IOException {
        this("dictionary-common.txt", findMultiWordAnagram);
    }

    /**
     * Create an anagram finder using a dictionary resource
     *
     * @param dictionaryFilename   Location of the dictionary containing the valid
     *                             words
     * @param findMultiWordAnagram specify whether to find anagrams consisting of
     *                             multiple words
     * @throws IOException if the dictionary cannot be loaded
     */
    public AnagramSolver(String dictionaryFilename, boolean findMultiWordAnagram) throws IOException {
        this.dictionary = dictionaryReader.readDictionaryAsTrie(dictionaryFilename);
        this.findMultiWordAnagram = findMultiWordAnagram;
    }

    /**
     * Find all anagrams for 'text'
     *
     * @param text        the work (or random letters) for which to look for
     *                    anagrams
     * @param uniqueWords in the case of multi-word anagrams, specify wether to
     *                    return unique words or not. For example, "SNOW MAN" and
     *                    "MAN SNOW" will be consolidate to "MAN SNOW"
     * @return the collection of valid anagrams
     */
    public Set<String> solve(String text, boolean uniqueWords) {
        Set<String> words = solve(text);
        if (uniqueWords) {
            return findUniqueWords(words);
        }
        return words;
    }

    /**
     * Find all anagrams for 'text'
     *
     * @param text the work (or random letters) for which to look for
     *             anagrams
     * @return the collection of valid anagrams
     */
    public Set<String> solve(String text) {
        Set<String> words = new LinkedHashSet<>();
        findPaths("", text.toUpperCase(), 0, words);
        return words;
    }

    private void findPaths(String prefix, CharSequence remaining, int index, Set<String> words) {
        String candidate = findMultiWordAnagram ? prefix.substring(index) : prefix;
        if (remaining.length() == 0) {
            if (dictionary.containsWord(candidate)) {
                words.add(prefix);
            }
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String next = candidate + c;
            if (findMultiWordAnagram && dictionary.containsWord(next)) {
                // start looking for another word
                findPaths(prefix + c + " ", removeFirst(remaining, c), index + next.length() + 1, words);
            }
            if (dictionary.isValidPrefix(next)) {
                findPaths(prefix + c, removeFirst(remaining, c), index, words);
            }
        }
    }

    private Set<String> findUniqueWords(Set<String> words) {
        return words.stream().map(w -> Arrays.stream(w.split("\\s+")).sorted().collect(Collectors.joining(" ")))
                .sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private CharSequence removeFirst(CharSequence letters, char letter) {
        StringBuilder newList = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if (c == letter && !found) {
                found = true;
            } else {
                newList.append(c);
            }
        }
        return newList;
    }

    public boolean isFindMultiWordAnagram() {
        return findMultiWordAnagram;
    }
}
