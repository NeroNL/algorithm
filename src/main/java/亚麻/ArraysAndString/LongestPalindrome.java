package 亚麻.ArraysAndString;

/**
 * Given a string s, findWithDuplicates the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int mx = 0, id = 0;

        String f = "";

        for (int i = 0; i < s.length(); ++i) {
            f += "#" + s.charAt(i);
        }

        f += "#";
        int[] map = new int[s.length()+1];
        for (int i = 1; i < f.length(); ++i) {

            if (mx > i) {
                map[i] = Math.min(map[2*id - i], mx - i);
            } else {
                map[i] = 1;
            }

            while (i - map[i] >= 0 && i + map[i] < f.length() && s.charAt(i - map[i]) == s.charAt(i + map[i])) {
                map[i]++;
            }

            if (map[i] + i > mx) {
                mx = map[i] + i;
                id = i;
            }
        }

        mx = 0;
        id = 0;

        for (int i = 0; i < map.length; ++i) {
            if (map[i] > mx) {
                mx = map[i];
                id = i;
            }
        }

        String res = f.charAt(id) == '#' ? "" : f.substring(id,id+1);
        for (int i = 1; i <= mx; ++i) {
            res = f.charAt(id-i) + res + f.charAt(id+i);
        }

        return res;
    }
}
