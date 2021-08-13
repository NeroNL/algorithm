package Airbnb;

public class FindMedianInLargeFile {

    private int search(int[] arr, int k, int l , int r) {
        if (l >= r) return l;

        int res = l, count = 0;
        int guess = l + (r-l)/2;

        for (int num : arr) {
            if (num <= guess) {
                count++;
                res = Math.max(num, res);
            }
        }

        if (count == k) return res;
        else if (count < k) return search(arr, k, Math.max(res+1, guess), r);
        else return search(arr, k, l, guess);
    }

    public int find(int[] arr) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, count = 0;
        for (int num : arr) {
            l = Math.min(l, num);
            r = Math.max(r, num);
            count++;
        }

        if (count % 2 == 1) {
            return search(arr, count/2, l, r);
        } else {
            return (search(arr, count/2, l, r) + search(arr, count/2+1, l, r))/2;
        }
    }
}
