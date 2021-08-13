package dynamicProgramming;

public class Backpack {

    /**
     * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
     * @param m
     * @param A
     * @return
     */
    public static int backpackI(int m, int[] A) {
        int f[] = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }

    /**
     * Given n items with size Ai and value Vi, and a backpack with size m. You can take each item multiple times.
     * What's the maximum value can you put into the backpack?
     * @param m
     * @param A
     * @param V
     * @return
     */
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[] dp = new int[m+1];

        for (int i = 1; i <= n; ++i) {
            int[] tmp = new int[m+1];
            for (int j = A[i-1]; j <= m; ++j) {
                tmp[j] = Math.max(tmp[j], dp[j-A[i-1]] + V[i-1]);
            }
            dp = tmp;
        }


        return dp[m];
    }

    /**
     * 有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     * @param m V
     * @param W weight
     * @param C value
     * @param T capacity
     * @return
     */
    public static int backPackIII(int m, int[] C, int[] W, int[] T) {
        int n = C.length;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = W[i]; j <= m; ++j) {
                int k = 0;
                while (k < T[i-1] && j - W[i-1] * k >= 0) {
                    dp[i-1][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i-1]*k] + C[i-1]*k);
                    ++k;
                }
            }
        }

        return dp[n][m];
    }

    /**
     * 对于每件物品，具有两种不同的费用；选择这件物品必须同时付出这两种代价；对于每种代价都有一个可付出的最大值（背包容量）。问怎样选择物品可以得到最大的价值。设这两种代价分别为代价1和代价2，第i件物品所需的两种代价分别为a[i]和b[i]。两种代价可付出的最大值（两种背包容量）分别为V和U。物品的价值为w[i]。
     * @param m1
     * @param m2
     * @param W1
     * @param W2
     * @param V
     * @return
     */
    public static int backPackV(int m1, int m2, int[] W1, int[] W2, int[] V) {
        int n = W1.length;
        int[][] dp = new int[m1+1][m2+1];

        for (int i = 1; i <= n; ++i) {
            int[][] tmp = new int[m1+1][m2+1];
            for (int j = W1[i-1]; j <= m1; ++j) {
                for (int k = W2[i-1]; k <= m2; ++k) {
                    tmp[j][j] = Math.max(tmp[j][j], dp[j-W1[i-1]][k-W2[i-1]] + V[i-1]);
                }
            }
            dp = tmp;
        }

        return dp[m1][m2];
    }


    /**
     * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。这些物品被划分为若干组，
     * 每组中的物品互相冲突，最多选一件。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     * @param m
     * @param W
     * @param V
     * @return
     */
    public static int backPackVI(int m, int[][] W, int[][] V) {
        int n = W.length;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = m; j >= 0; ++j) {
                for (int k = 0; k < W[i-1].length; ++k) {
                    int w = W[i-1][k], v = V[i-1][k];
                    if (j >= w) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w] + v);
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[n][m];
    }
}
