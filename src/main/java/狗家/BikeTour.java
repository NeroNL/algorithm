package 狗家;

import java.util.Scanner;

/**
 * Li has planned a bike tour through the mountains of Switzerland. His tour consists of N checkpoints, numbered from 1 to N in the order he will visit them. The i-th checkpoint has a height of Hi.
 *
 * A checkpoint is a peak if:
 * It is not the 1st checkpoint or the N-th checkpoint, and
 * The height of the checkpoint is strictly greater than the checkpoint immediately before it and the checkpoint immediately after it.
 *
 * Please help Li find out the number of peaks.
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the integer N. The second line contains N integers. The i-th integer is Hi.
 *
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of peaks in Li's bike tour.
 *
 * Limits
 * Time limit: 10 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ Hi ≤ 100.
 *
 * Test set 1
 * 3 ≤ N ≤ 5.
 *
 * Test set 2
 * 3 ≤ N ≤ 100.
 *
 * Sample
 *
 * Input
 *
 * Output
 *
 * 4
 * 3
 * 10 20 14
 * 4
 * 7 7 7 7
 * 5
 * 10 90 20 90 10
 * 3
 * 10 3 10
 *
 *
 * Case #1: 1
 * Case #2: 0
 * Case #3: 2
 * Case #4: 0
 *
 *
 * In sample case #1, the 2nd checkpoint is a peak.
 * In sample case #2, there are no peaks.
 * In sample case #3, the 2nd and 4th checkpoint are peaks.
 * In sample case #4, there are no peaks.
 */

public class BikeTour {

    public static void printPeek(int[] array, int testCase) {
        int result = 0;
        if (array.length <= 2) {
            System.out.println(String.format("Case #%s: %s", testCase, result));
            return ;
        }

        for (int i = 1; i < array.length-1; ++i) {
            if (array[i-1] < array[i] && array[i] > array[i+1]) {
                result++;
            }
        }
        System.out.println(String.format("Case #%s: %s", testCase, result));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testCase; ++i) {
            int length = Integer.parseInt(in.nextLine());
            int[] array = new int[length];
            String[] values = in.nextLine().split(" ");
            for (int j = 0; j < length; ++j) {
                array[j] = Integer.parseInt(values[j]);
            }
            printPeek(array, i+1);
        }
    }
}
