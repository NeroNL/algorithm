package Airbnb;

public class HilbertCurve {

    public int solve(int x, int y, int iter) {
        if (iter == 0) return 1;
        int len = 1 << (iter -1);
        int num = 1 << (2 * (iter-1));

        if (x >= len && y >= len) {
            // 3 Shape is identical with previous iteration
            return 2 * num + solve(x-len, y-len, iter-1);
        } else if (x < len && y >= len) {
            // 2 Shape is identical with previous iteration
            return num + solve(x, y-len, iter-1);
        } else if (x < len) {
            // 1 Clock-wise rotate 90
            return solve(y, x, iter-1);
        } else {
            // 4 Anti-Clockwise rotate 90
            return 3 * num + solve(len-y-1, 2 * len - x - 1, iter-1);
        }
    }
}
