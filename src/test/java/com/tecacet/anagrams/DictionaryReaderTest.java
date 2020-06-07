package com.tecacet.anagrams;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;

public class DictionaryReaderTest {

    @Test
    public void testReadDictionaryAsTrie() throws IOException {
        DictionaryReader dictionaryReader = new DictionaryReader();
        Trie trie = dictionaryReader.readDictionaryAsTrie("dictionary-common.txt");
        assertTrue(trie.containsWord("HOME"));
    }

    @Test
    public void testReadLowercaseDictionary() throws IOException {
        DictionaryReader dictionaryReader = new DictionaryReader();
        Trie trie = dictionaryReader.readDictionaryAsTrie("english3.txt");
        assertTrue(trie.containsWord("HOME"));
    }

}
