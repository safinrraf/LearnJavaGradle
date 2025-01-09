package com.learn.classic;

/**
 * <a href="https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, String Matching}
 * </ul>
 * <ul>Hints
 * <li> {@code Go through each word in words and increment the answer if pref is a prefix of the word.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words.length <= 100}
 * <li> {@code 1 <= words[i].length, pref.length <= 100}
 * <li> {@code words[i] and pref consist of lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 09.01.25 08:14
 */
class PrefixWords {

    /**
     * Approach 3: Trie
     * <p>
     * {@code Time Complexity O(n * l + m)}<br>
     * {@code Space Complexity O(n * l)}
     * </p>
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        Trie trie = new Trie();

        // Add all words to trie
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.countPrefix(pref);
    }

    private class Trie {

        // Node class represents each character in Trie
        class Node {

            // Links to child nodes
            Node[] links;
            // Number of strings having prefix till this node
            int count;

            Node() {
                // For lowercase English letters
                links = new Node[26];
                count = 0;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        // Add word to trie and update prefix counts
        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    curr.links[c - 'a'] = new Node();
                }
                curr = curr.links[c - 'a'];
                curr.count++; // Increment count for this prefix
            }
        }

        // Return count of strings having pref as prefix
        public int countPrefix(String pref) {
            Node curr = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    return 0; // Prefix not found
                }
                curr = curr.links[c - 'a'];
            }
            return curr.count; // Return count at last node
        }
    }
}
