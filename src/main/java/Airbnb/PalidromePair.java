package Airbnb;

import java.util.*;

/**
 * Given a list of unique words, findWithDuplicates all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */

public class PalidromePair {

    class Trie {
        Trie[] children = new Trie[26];
        // if there is palindrome inside same string, record it;
        // there could be a case that there are multiple same string in the test cases
        List<Integer> pos = new ArrayList<>();

        // index
        int id;
        boolean isLeaf;

        Trie() {
            id = -1;
            isLeaf = false;
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    List<List<Integer>> ret;

    private boolean isPalidrome(String s, int i, int e) {
        while (i <= e) {
            if (s.charAt(i) != s.charAt(e)) {
                return false;
            }

            ++i;
            --e;
        }

        return true;
    }


    private void insert(Trie root, String key, int id) {
        Trie node = root;

        for (int i = key.length() - 1; i >= 0; --i) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }

            if (isPalidrome(key, 0, i)) {
                node.pos.add(id);
            }
            node = node.children[index];
        }

        node.id = id;
        node.pos.add(id);
        node.isLeaf = true;
    }

    private void search(Trie root, String key, int id) {
        Trie node = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';

            if (node.id >= 0 && node.id != id && isPalidrome(key, i, key.length()-1)) {
                List<Integer> l = new ArrayList<>();
                l.add(id);
                l.add(node.id);
                ret.add(l);
            }

            if (node.children[index] == null) {
                return ;
            }

            node = node.children[index];
        }

        for (int i : node.pos) {
            if (i == id) {
                continue ;
            }

            List<Integer> l = new ArrayList<>();
            l.add(id);
            l.add(i);
            ret.add(l);
        }

    }

    public List<List<Integer>> palindromePairs(String[] words) {

        Trie root = new Trie();

        for (int i = 0; i < words.length; ++i) {
            insert(root, words[i], i);
        }

        ret = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            search(root, words[i], i);
        }

        return ret;
    }

    private boolean isPal(String s) {
        int l = 0, r = s.length()-1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            ++l;
            --r;
        }
        return l > r;
    }

    public List<List<Integer>> palindromePairsSimple(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) return ans;
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; ++i) map.put(words[i], i);

        for (int i = 0; i < n; ++i) {
            String w = words[i];
            int m = w.length();
            for (int j = 0; j <= m; ++j) {
                String str1 = w.substring(0, j), str2 = w.substring(j);
                if (isPal(str1)) {
                    String rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        ans.add(Arrays.asList(map.get(rev), i));
                    }
                }

                if (isPal(str2) && !str2.isEmpty()) {
                    String rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        ans.add(Arrays.asList(i, map.get(rev)));
                    }
                }
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        PalidromePair palidromePair = new PalidromePair();

        String[] words = {"abcd","dcba","lls","s","sssll"};

        List<List<Integer>> lists = palidromePair.palindromePairs(words);

        int i = 0;

        for (List<Integer> list : lists) {
            System.out.println("Pair num: " + i++);
            String tmp = "";
            for (Integer num : list) {
                tmp += words[num] + ",";
            }
            System.out.println("Values are " + tmp);
        }
    }
}
