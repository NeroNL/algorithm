package GoogleKickStartRoundD2020;

import java.util.Scanner;

public class P1 {

    public static void findLocalPeak(int[] days, int testNum) {
        int max = Integer.MIN_VALUE, ans = 0, n = days.length, i = 0;
        for (; i < n-1; ++i) {
            if (days[i] > max && days[i] > days[i+1]) ans++;
            max = Math.max(days[i], max);
        }
        if (days[i] > max) ans++;
        System.out.println(String.format("Case #%s: %s", testNum, ans));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0 ; i < n; ++i) {
            int l = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[l];
            String[] strs = scanner.nextLine().split(" ");
            for (int j = 0; j < l; ++j) {
                arr[j] = Integer.parseInt(strs[j]);
            }
            findLocalPeak(arr, i+1);
        }
    }
}
