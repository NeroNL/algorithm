public class ZeroOut {

    public int[][] zero(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return matrix;

        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; ++i) {

            boolean found = false;

            for (int j = i; j < m; ++j) {
                if (matrix[j][i] == 0) {
                    found = true;
                    break;
                }
            }

            if (found) {
                for (int j = i; j < m; ++j) {
                    matrix[j][i] = 0;
                }
            }

            found = false;

            for (int j = i; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    found = true;
                    break;
                }
            }

            if (found) {
                for (int j = i; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,0,1},{1,0,1,1},{1,1,1,1}};
        ZeroOut zeroOut = new ZeroOut();

        int[][] res = zeroOut.zero(matrix);

        for (int i = 0; i < res.length; ++i) {
            System.out.println();
            for (int j = 0; j < res[i].length; ++j) {
                System.out.print(res[i][j]+"|");
            }
        }
    }

}
