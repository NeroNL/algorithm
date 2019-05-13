import java.util.*;

public class SubarrayTarget {

    public static boolean contains(int[] arr, int target) {

        int r = 0;
        double sum = 0;

        for (int i = 0; i < arr.length; ++i) {
            int num = arr[i];
            sum += num;

            while (r <= i && sum > target) {
                sum -= arr[r];
                r++;
            }

            if (sum == target && r <= i) {
                return true;
            }
        }

        return false;

    }


    public static boolean contains2(int[] arr, int target) {
        Set<Long> h = new HashSet<>();

        long pre = 0;
        for (int num : arr) {
            pre += num;
            if (h.contains(pre - target) || pre == target) return true;
            h.add(pre);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(contains(arr, 11));

        int[] arr2 = {-1,-2,-3};
        System.out.println(contains2(arr2, 0));
    }
}
