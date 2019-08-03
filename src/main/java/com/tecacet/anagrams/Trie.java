package com.tecacet.anagrams;

/**
 * Trie structure for storing a dictionary
 * 
 * @author dimitri
 *
 */
public class Trie  {
    private static final int A_POSITION = 65;

	private static final int R = 26; //ALL CAPS

    private Node root = new Node();

    private static class Node {
        private Boolean val;
        private Node[] next = new Node[R];
    }

    public boolean containsWord(CharSequence key) {
        return get(key) != null;
    }
    
    public Boolean get(CharSequence key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, CharSequence key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c - A_POSITION], key, d + 1);
    }
    	
    public void add(String key) {
        root = put(root, key, true, 0);
    }

    private Node put(Node x, CharSequence key, boolean val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c - A_POSITION] = put(x.next[c - A_POSITION], key, val, d + 1);
        return x;
    }
    
    public boolean isValidPrefix(CharSequence prefix) {
        Node x = get(root, prefix, 0);
        return x != null;
    }

}
