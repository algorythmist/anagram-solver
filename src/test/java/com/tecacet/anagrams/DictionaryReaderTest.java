package com.tecacet.anagrams;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class DictionaryReaderTest {

	@Test
	public void testReadDictionaryAsTrie() throws IOException {
		DictionaryReader dictionaryReader = new DictionaryReader();
		Trie trie = dictionaryReader.readDictionaryAsTrie("dictionary-common.txt");
		assertTrue(trie.containsWord("HOME"));
	}

}
