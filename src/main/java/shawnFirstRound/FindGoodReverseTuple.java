package shawnFirstRound;

import java.util.*;

public class FindGoodReverseTuple {

    private static int getRever(int num) {
        int res = 0;
        while (num > 0) {
            res = res*10 + num % 10;
            num /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        int[] arr = new int[n], rev = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(line[i]);
            rev[i] = arr[i] - getRever(arr[i]);
        }

        Arrays.sort(rev);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = i+1, k = n-1;
            while (j < k) {
                int sum = rev[i] + rev[j] + rev[k];
                if (sum == 0) {
                    ans++;
                    ++j;
                    --k;
                }
                else if (sum > 0) --k;
                else ++j;
            }
        }

        System.out.println(ans);
    }
}
