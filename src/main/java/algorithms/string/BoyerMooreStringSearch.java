package algorithms.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoyerMooreStringSearch {

    private static final int MAX_ALPHABET_SIZE = 256;

    public List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> ans = new ArrayList<>();
        if (Objects.isNull(text) || Objects.isNull(pattern) || pattern.length() > text.length() || pattern.isEmpty()) {
            return ans;
        }

        int[] skipTable = new int[MAX_ALPHABET_SIZE];
        int n = text.length(), m = pattern.length();
        for (int i = 0; i < m; ++i) {
            skipTable[pattern.charAt(i)] = i;
        }

        for (int textIndex = m-1, patternIndex = m-1; textIndex < n; ) {
            if (patternIndex >= 0 && text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                if (patternIndex == 0) {
                    ans.add(textIndex);
                } else {
                    textIndex--;
                }
                patternIndex--;
            } else {
                textIndex += m - Math.min(Math.max(patternIndex, 0), skipTable[text.charAt(textIndex)]+1);
                patternIndex = m-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BoyerMooreStringSearch searcher = new BoyerMooreStringSearch();
        String t = "ABABAAABAABAB";
        String p = "AA";

        // Prints: [4, 5, 8]
        System.out.println(searcher.findOccurrences(t, p));
    }
}
