package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {

    class Trie {
        boolean isWord;
        Trie[] children;

        public Trie() {
            isWord = false;
            children = new Trie[26];
        }
    }

    Trie root;

    public List<String> solve(String[] words, String target, int k) {
        root = new Trie();

        for (String word : words) {
            insert(word);
        }

        int[] prev = new int[target.length()+1];

        for (int i = 0; i <= target.length(); ++i) prev[i] = i;

        List<String> ans = new ArrayList<>();

        Trie node = root;
        search("", target, k, prev, node, ans);

        return ans;

    }

    private void insert(String s) {
        Trie node = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new Trie();
            }

            if (i == s.length()-1) node.children[c-'a'].isWord = true;

            node = node.children[c-'a'];
        }
    }

    private void search(String curr, String target, int k, int[] prev, Trie root, List<String> result) {
        if (root.isWord) {
            if (prev[target.length()] <= k) {
                result.add(curr);
            } else {
                return ;
            }
        }

        for (int i = 0; i < root.children.length; ++i) {
            if (root.children[i] == null) continue;
            int[] curDist = new int[prev.length];
            curDist[0] = curr.length()+1;
            for (int j = 1; j < prev.length; ++j) {
                if (target.charAt(j-1) == (char)(i+'a')) {
                    curDist[j] = prev[j-1];
                } else {
                    curDist[j] = Math.min(curDist[j-1], Math.min(prev[j], prev[j-1]))+1;
                }
            }

            search(curr + (char)(i+'a'), target, k, curDist, root.children[i], result);
        }
    }

    public static void main(String[] args) {
        String[] test1 = {"abc", "a", "ab", "abb", "abbc"};
        KEditDistance kEditDistance = new KEditDistance();
        for (String s : kEditDistance.solve(test1, "abb", 1)) {
            System.out.println(s);
        }
    }
}
