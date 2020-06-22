public class EqulibriumIndex {

    public int solve(int[] arr) {
        long sum = 0, leftSum =0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; ++i) {
            sum -= arr[i]; // 得出右边的sum

            if (sum == leftSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        EqulibriumIndex equlibriumIndex = new EqulibriumIndex();

        int[] invalidCase = {1, 2, 3};
        int[] normalCase = {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(equlibriumIndex.solve(invalidCase));
        System.out.println(equlibriumIndex.solve(normalCase));
    }
}
