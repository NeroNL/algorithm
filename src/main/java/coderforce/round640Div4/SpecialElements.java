package coderforce.round640Div4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Pay attention to the non-standard memory limit in this problem.
 *
 * In order to cut off efficient solutions from inefficient ones in this problem, the time limit is rather strict. Prefer to use compiled statically typed languages (e.g. C++). If you use Python, then submit solutions on PyPy. Try to write an efficient solution.
 *
 * The array 𝑎=[𝑎1,𝑎2,…,𝑎𝑛] (1≤𝑎𝑖≤𝑛) is given. Its element 𝑎𝑖 is called special if there exists a pair of indices 𝑙 and 𝑟 (1≤𝑙<𝑟≤𝑛) such that 𝑎𝑖=𝑎𝑙+𝑎𝑙+1+…+𝑎𝑟. In other words, an element is called special if it can be represented as the sum of two or more consecutive elements of an array (no matter if they are special or not).
 *
 * Print the number of special elements of the given array 𝑎.
 *
 * For example, if 𝑛=9 and 𝑎=[3,1,4,1,5,9,2,6,5], then the answer is 5:
 *
 * 𝑎3=4 is a special element, since 𝑎3=4=𝑎1+𝑎2=3+1;
 * 𝑎5=5 is a special element, since 𝑎5=5=𝑎2+𝑎3=1+4;
 * 𝑎6=9 is a special element, since 𝑎6=9=𝑎1+𝑎2+𝑎3+𝑎4=3+1+4+1;
 * 𝑎8=6 is a special element, since 𝑎8=6=𝑎2+𝑎3+𝑎4=1+4+1;
 * 𝑎9=5 is a special element, since 𝑎9=5=𝑎2+𝑎3=1+4.
 * Please note that some of the elements of the array 𝑎 may be equal — if several elements are equal and special, then all of them should be counted in the answer.
 *
 * Input
 * The first line contains an integer 𝑡 (1≤𝑡≤1000) — the number of test cases in the input. Then 𝑡 test cases follow.
 *
 * Each test case is given in two lines. The first line contains an integer 𝑛 (1≤𝑛≤8000) — the length of the array 𝑎. The second line contains integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤𝑛).
 *
 * It is guaranteed that the sum of the values of 𝑛 for all test cases in the input does not exceed 8000.
 *
 * Output
 * Print 𝑡 numbers — the number of special elements for each of the given arrays.
 *
 * Example
 * inputCopy
 * 5
 * 9
 * 3 1 4 1 5 9 2 6 5
 * 3
 * 1 1 2
 * 5
 * 1 1 1 1 1
 * 8
 * 8 7 6 5 4 3 2 1
 * 1
 * 1
 * outputCopy
 * 5
 * 1
 * 0
 * 4
 * 0
 */
public class SpecialElements {

    public static void solve(int n, int[] arr) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int sum = 0, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            sum += a;
            dp[i] = sum;
            numsMap.put(a, numsMap.getOrDefault(a, 0) + 1);
        }

        for (int i = n-1; i >= 0; --i) {
            sum = dp[i];
            for(int j = 0; j < i-1; ++j) {
                if (numsMap.containsKey(sum - dp[j])) {
                    ans += numsMap.get(sum-dp[j]);
                    numsMap.remove(sum - dp[j]);
                }
            }
            if (i != 0 && numsMap.containsKey(sum)) {
                ans += numsMap.get(sum);
                numsMap.remove(sum);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next());
        while(len-- > 0) {
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; ++i) {
                arr[i] = scanner.nextInt();
            }
            solve(num, arr);
        }
    }
}
