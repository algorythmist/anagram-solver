package com.tecacet.anagrams;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class to load a dictionary in a Trie
 * 
 * @author dimitri
 *
 */
public class DictionaryReader {

	public Trie readDictionaryAsTrie(String filename) throws IOException {
		Trie trie = new Trie();
		try {
			URI uri = ClassLoader.getSystemResource(filename).toURI();
			Files.lines(Paths.get(uri)).forEach(line -> trie.add(line.toUpperCase()));
			return trie;
		} catch (URISyntaxException e) {
			throw new IOException(e);
		}
		
	}

}
