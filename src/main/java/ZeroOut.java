public class ZeroOut {

    public int[][] zero(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return ;

        int n = matrix.length, m = matrix[0].length;
        boolean rowZero = false, colZero = false;
        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 0) {
                colZero = true;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if(matrix[i][0] == 0) {
                rowZero = true;
                break;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (colZero) {
            for (int j = 0; j < m; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (rowZero) {
            for (int i = 0; i < n; ++i) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
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
