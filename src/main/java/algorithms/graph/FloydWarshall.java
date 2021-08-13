package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

    double[][] dp;
    Integer[][] next;
    int n;
    boolean solved;

    int POSITIVE_INFINITY = -1;

    public FloydWarshall(double[][] matrix) {
        this.n = matrix.length;
        this.dp = new double[n][n];
        this.next = new Integer[n][n];
        this.solved = false;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] != POSITIVE_INFINITY) {
                    next[i][j] = j;
                }
                dp[i][j] = matrix[i][j];
            }
        }
    }

    public double[][] getApspMatrix() {
        if (!solved) solve();
        return dp;
    }

    public void solve() {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = POSITIVE_INFINITY;
                        next[i][j] = -1;
                    }
                }
            }
        }

        solved = true;
    }

    public List<Integer> reconstructShortestPath(int start, int end) {
        if (!solved) solve();
        List<Integer> path = new ArrayList<>();
        if (dp[start][end] == POSITIVE_INFINITY) return path;
        int at = start;
        for (; at != end; at = next[at][end]) {
            if (at == -1) return null;
            path.add(at);
        }

        if (next[at][end] == -1) return null;
        path.add(end);
        return path;
    }
}
