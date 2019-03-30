package 亚麻;


import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length, m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0 ; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = i == 0 ? 1 : 1 + dp[i-1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, calculate(dp[i]));
        }

        return res;

    }


    private int calculate(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return res;
    }
}
