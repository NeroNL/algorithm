package sorting;

/**
 * Data structure	Array
 * Worst-case performance	{\displaystyle O(n^{2})}O(n^{2})
 * Best-case performance	{\displaystyle O(n)}O(n)
 * Average performance	{\displaystyle O(n^{2})}O(n^{2})
 * Worst-case space complexity	{\displaystyle O(1)}O(1) auxiliary
 */
public class GnomeSort {

    public void sort(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            if (i < 1 || arr[i] >= arr[i-1]) {
                ++i;
            } else {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
                --i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,3,5,1,6,11,85,43,59,12,0};

        new GnomeSort().sort(arr);

        StringBuilder str = new StringBuilder();
        for (int num : arr) {
            str.append(num).append(", ");
        }
        System.out.println(str);
    }
}
