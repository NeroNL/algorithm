package 亚麻.ArraysAndString;

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAStringII {

    public void reverseWords(char[] str) {
        int l = 0, r = 0;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == ' ') {
                r = i-1;
                while (l < r) {
                    char c = str[l];
                    str[l] = str[r];
                    str[r] = c;
                    l++;
                    r--;
                }
                l = i+1;
            }
        }

        r = str.length - 1;
        while (l < r) {
            char c = str[l];
            str[l] = str[r];
            str[r] = c;
            l++;
            r--;
        }

        for (int i = 0; i < str.length / 2; ++i) {
            char c = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = c;
        }
    }
}
