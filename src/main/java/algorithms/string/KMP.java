package algorithms.string;

public class KMP {
    // dp[状态][字符] = 下个状态
    private int[][] dp;
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        int n = pattern.length();
        // 256 => ascii code
        this.dp = new int[n][256];
        this.dp[0][pattern.charAt(0)] = 1;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            for (int c = 0; c < 256; ++c) {
                if (c == pattern.charAt(i)) {
                    this.dp[i][c] = i+1;
                } else {
                    this.dp[i][c] = this.dp[x][c];
                }
            }

            x = this.dp[x][pattern.charAt(i)];
        }
    }

    public int find(String text) {
        int n = pattern.length(), m = text.length();
        int j = 0;
        for (int i = 0; i < m; ++i) {
            char c = text.charAt(i);
            j = this.dp[j][c];
            if (j == n) {
                return i - n + 1;
            }
        }

        return -1;
    }
}
