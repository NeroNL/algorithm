package pinterest;

import java.util.HashMap;
import java.util.Map;

import static pinterest.BlackList.Trie.*;

public class BlackList {

    public static class Trie {

        public static class TrieNode {

            public boolean isWord;
            public Map<Integer, TrieNode> children;

            public TrieNode() {
                isWord = false;
                children = new HashMap<>();
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c-'a')) {
                    node.children.put(c-'a', new TrieNode());
                }
                node = node.children.get(c - 'a');
            }
            node.isWord = true;
        }
    }

    private static boolean solve(String sentence, String[] blackList) {
        Trie trie = new Trie();
        for (String str : blackList) {
            trie.insert(str);
        }
        for (int i = 0; i < sentence.length(); ++i) {
            int j = i;
            TrieNode node = trie.root;
            for (; j < sentence.length(); ++j) {
                // this line can be optimize
                if (node.children.containsKey(sentence.charAt(j)-'a')) {
                    node = node.children.get(sentence.charAt(j) - 'a');
                } else {
                    break;
                }
            }
            if (node.isWord) {
                if (j < sentence.length()) {
                    return sentence.charAt(j) != ' ';
                } else {
                    return false;
                }
            }

        }

        return true;
    }

    private static boolean solve2(String sentence, String[] blackList) {
        for (String block : blackList) {
            if (sentence.contains(block)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] blackList = {"machine guns", "terrorist activity", "muder"};

        String sentence1 = "";
        for (int i = 0; i < 10000; ++i) {
            sentence1 += "asdasdasdasd";
        }
        sentence1 += "I bought a couple of machine guns yesterday.";
        String sentence2 = "";
        for (int i = 0; i < 10000; ++i) {
            sentence2 += "asdasdasdasd";
        }
        sentence2 += "I suspect that man is a murderer.";

        // solution1 is slower than slower2

        long p = System.currentTimeMillis();
        System.out.println(solve(sentence1, blackList));
        System.out.println(solve(sentence2, blackList));
        System.out.println(System.currentTimeMillis()-p);

        p = System.currentTimeMillis();
        System.out.println(solve2(sentence1, blackList));
        System.out.println(solve2(sentence2, blackList));
        System.out.println(System.currentTimeMillis()-p);
    }
}
