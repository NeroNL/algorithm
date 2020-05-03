package 狗家;

import java.util.Scanner;

public class WanderingRobot {

    static int n, m, l, u, r, d;

    private static boolean isInHold(int x, int y) {
        return l-1 <= x && x < r && u - 1 <= y && y < d;
    }

    public static void solve() {
        double[][] grid = new double[n][m];
        grid[0][0] = 1L;
        for (int i = 1; i < n; ++i) {
            grid[i][0] = grid[i-1][0] * 0.5;
        }

        for (int i = 1; i < m; ++i) {
            grid[0][i] = grid[0][i-1] * 0.5;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                double up = i == n-1 ? grid[0][m-1] : grid[i][j-1] * 0.5;
                double left = j == m-1 ? grid[n-1][0] : grid[i-1][j] * 0.5;
                grid[i][j] = up + left;
            }
        }
    }


    public static void print(Object testCase, Object x, Object y){
        System.out.println(String.format("Case #%s: %s %s", testCase, x, y));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testCase; ++i) {
            String[] str = in.next().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            l = Integer.parseInt(str[2]);
            u = Integer.parseInt(str[3]);
            r = Integer.parseInt(str[4]);
            d = Integer.parseInt(str[5]);
            solve();
        }
    }
}
