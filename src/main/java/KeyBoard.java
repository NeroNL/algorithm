import java.util.Scanner;

/**
 * 一般我们在键盘上打字，有分大小写。
 *
 * 假设我们现在要打出一串字母，求我们打出所有字母的最小敲击数。
 *
 * 敲击数计算如下：
 * 1. 一次字母敲击 +1
 * 2. 一次cap lock +1
 * 3. 一次shift +1
 *
 * 规则如下：
 * 1. by default一开始全是小写
 * 2. 一次cap lock会使之后全部输入变成大写，再一次会全部变成小写
 * 3. 一次shift只能使下一次的输入变成大写
 *
 *
 * Constraints:
 * 1. input肯定是valid input，只包含了a-zA-Z
 * 2. input永不为空
 * 3. 1 <= output <= 10^9
 *
 * Normally when we type in keyboard, character can be either upper-cased or lower-cased,
 * and the way we type upper-cased letter is by pressing CAP or SHIFT.
 *
 * Assuming we need to type a sequence of character,
 * and we would like to find out the minimum number of clicks to type out sequence of characters
 *
 * The rules to calculate clicks is as follows:
 * 1. one character + 1
 * 2. one CAP + 1
 * 3. one SHIFT + 1
 *
 * General rules:
 * 1. at the beginning, we all start by type letters in lower-cased
 * 2. one click on CAP will change all the following letters to upper-cased unless press on CAP again
 * 3. one SHIFT only will make the next letter to be upper-cased.
 *
 * Constraints:
 * 1. input is always valid, only [a-zA-Z]
 * 2. input is never empty
 * 3. 1 <= output <= 10^9
 *
 * Example:
 *
 * input:
 * 3            --  number of test cases will be entered
 * "aaa"        --  test case 1
 * 3            --  test case 1 output
 * "aAa"        --  test case 2
 * 4            --  test case 2 output
 * "aAAAAAAAa"  --  test case 3
 * 11           --  test case 3 output
 */
public class KeyBoard {

    public int solve(String s) {
        int ans = 0, count = 0;
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                ans += Math.min(count, 2);
                count = 0;
            } else {
                count++;
            }
        }
        return ans + Math.min(count, 2) + s.length();
    }

    public static void main(String[] str) {
        KeyBoard sol = new KeyBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println(sol.solve(scanner.nextLine()));
    }

    /*double[][] memo;
    public int solve(String str) {
        int n = str.length();
        memo = new double[n][2];
        return (int)dp(str, 0, 0, "");
    }

    private double dp(String s, int index, int lock, String t) {
        int n = s.length();
        if (t.equals(s)) return 0;
        if (index == n) return Double.POSITIVE_INFINITY;
        if (memo[index][lock] !=0) return memo[index][lock];

        char c = s.charAt(index);
        if (lock == 1) c = Character.toUpperCase(c);
        else c = Character.toLowerCase(c);

        double ans = Double.POSITIVE_INFINITY;
        if (c == s.charAt(index)) {
            // do nothing
            double a1 = dp(s, index+1, lock, t + c) + 1;
            ans = Math.min(ans, a1);
        } else {
            // shift
            if (lock == 1) c = Character.toLowerCase(c);
            else c = Character.toUpperCase(c);
            double a2 = dp(s, index+1, lock, t+c) + 2;
            ans = Math.min(ans, a2);
            // switch cap
            double a3 = dp(s, index+1, 1-lock, t+c) + 2;
            ans = Math.min(ans, a3);
        }

        if (ans != Double.POSITIVE_INFINITY) memo[index][lock] = ans;

        return ans;
    }*/
}
