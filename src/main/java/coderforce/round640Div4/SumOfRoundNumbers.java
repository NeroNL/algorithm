import java.util.Scanner;

/**
 * A positive (strictly greater than zero) integer is called round if it is of the form d00...0. In other words, a positive integer is round if all its digits except the leftmost (most significant) are equal to zero. In particular, all numbers from 1 to 9 (inclusive) are round.
 *
 * For example, the following numbers are round: 4000, 1, 9, 800, 90. The following numbers are not round: 110, 707, 222, 1001.
 *
 * You are given a positive integer 𝑛 (1≤𝑛≤104). Represent the number 𝑛 as a sum of round numbers using the minimum number of summands (addends). In other words, you need to represent the given number 𝑛 as a sum of the least number of terms, each of which is a round number.
 *
 * Input
 * The first line contains an integer 𝑡 (1≤𝑡≤104) — the number of test cases in the input. Then 𝑡 test cases follow.
 *
 * Each test case is a line containing an integer 𝑛 (1≤𝑛≤104).
 *
 * Output
 * Print 𝑡 answers to the test cases. Each answer must begin with an integer 𝑘 — the minimum number of summands. Next, 𝑘 terms must follow, each of which is a round number, and their sum is 𝑛. The terms can be printed in any order. If there are several answers, print any of them.
 *
 * Example
 * inputCopy
 * 5
 * 5009
 * 7
 * 9876
 * 10000
 * 10
 * outputCopy
 * 2
 * 5000 9
 * 1
 * 7
 * 4
 * 800 70 6 9000
 * 1
 * 10000
 * 1
 * 10
 */
public class SumOfRoundNumbers {

    public static void solve(int num) {
        int index = 1;
        int count = 0;
        String ans = "";
        while(num > 0) {

            if (num % 10 != 0) {
                //System.out.println((num % 10) * index);
                ans = ((num % 10) * index) + " " + ans;
                count++;
            }
            index *= 10;
            num /= 10;
        }
        System.out.println(count);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next());
        for (int i = 0; i < len; ++i) {
            solve(Integer.parseInt(scanner.next()));
        }
    }
}
