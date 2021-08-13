package algorithms.search;

/**
 * An implementation of interpolation search
 *
 * <p>Time Complexity: O(log(log(n))) if data is uniform O(n) in worst case
 */
public class InterpolationSearch {
    
    public static int solve(int[] arr, int target) {
        int n = arr.length, l = 0, mid = 0, r = n-1;

        while(arr[l] <= target && target <= arr[r]) {
            mid = l + ((target - arr[l]) * (r-l)) / (arr[r] - arr[l]);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        if(arr[l] == target) return l;
        return -1;
    }

    public static void main(String[] str) {
        int[] values = {10, 20, 25, 35, 50, 70, 85, 100, 110, 120, 125};

        // Since 25 exists in the values array the interpolation search
        // returns that it has found 25 at the index 2
        System.out.println(solve(values, 25));

        // 111 does not exist so we get -1 as an index value
        System.out.println(solve(values, 111));
    }
}