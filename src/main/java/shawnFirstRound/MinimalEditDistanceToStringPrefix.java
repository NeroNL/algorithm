package shawnFirstRound;

import java.util.Scanner;

public class MinimalEditDistanceToStringPrefix {

    public static int solve(String a, String b) {

        int n = a.length(), m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = i;
        for (int j = 0; j <= m; ++j) dp[0][j] = j;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= m; ++j) {
            ans = Math.min(ans, dp[n][j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        System.out.println(solve(ss[0], ss[1]));
    }
}
