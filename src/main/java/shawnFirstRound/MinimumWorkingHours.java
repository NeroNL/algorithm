package shawnFirstRound;

import java.util.Scanner;

public class MinimumWorkingHours {

    private static long check(long[] arr, long m) {
        int n = arr.length, i = 0;
        long count = 0, ans = 0;
        while (i < n) {
            long sum = count + arr[i];
            if (sum > m) {
                count = 0;
                ans++;
            }
            count += arr[i++];
        }

        return ans + (count == 0 ? 0 : 1);
    }

    public static long solve(long[] arr, long k) {
        long sum = 0, l = 0;
        for (long num : arr) {
            sum += num;
            l = Math.max(l, num);
        }
        long r = sum;
        while (l <= r) {
            long m = l + (r-l) / 2;
            if (check(arr, m) <= k) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] ls = line.split(" ");
        int n = Integer.parseInt(ls[0]);
        long k = Long.parseLong(ls[1]);
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Long.parseLong(scanner.nextLine());
        }
        System.out.println(solve(arr, k));
    }
}
