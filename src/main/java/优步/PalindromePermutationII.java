package 优步;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 *
 * Example 1:
 *
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 */
public class PalindromePermutationII {

    Set<String> set;

    public List<String> generatePalindromes(String s) {
        set = new HashSet<>();
        int[] map = new int[128];
        char[] st = new char[s.length()/2];

        if (!canPermutePalidrome(s, map)) {
            return new ArrayList<>();
        }


        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; ++i) {
            if (map[i] % 2 == 1) {
                ch = (char) i;
            }

            for (int j = 0; j < map[i]/2; ++j) {
                st[k++] = (char) i;
            }
        }

        permute(st, 0, ch);
        return new ArrayList<>(set);
    }


    private boolean canPermutePalidrome(String s, int[] map) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 1) {
                ++count;
            } else{
                --count;
            }
        }

        return count <= 1;
    }

    private void swap (char[]s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    private void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            set.add(new String(s) + (ch == 0 ? " " : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; ++i) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l+1, ch);
                    swap(s, l, i);
                }
            }
        }
    }
}
