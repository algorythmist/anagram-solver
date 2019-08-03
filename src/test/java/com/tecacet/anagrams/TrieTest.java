package com.tecacet.anagrams;
import static org.junit.Assert.*;

import org.junit.Test;

import com.tecacet.anagrams.Trie;

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
