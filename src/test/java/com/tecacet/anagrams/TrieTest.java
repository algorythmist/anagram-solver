package com.tecacet.anagrams;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.add("BRAVE");
        assertFalse(trie.containsWord("B"));
        assertFalse(trie.containsWord("E"));
        assertTrue(trie.isValidPrefix("BR"));
    }

}
