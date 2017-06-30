public class Solution {
public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int row = n;
        int col = n;

        int mid = (n - 1) / 2;
        int count = 0;
        for (int i = 0; i <= mid; i ++) {
            for (int j = i; j <= col - 1 - i; j ++) {
                matrix[i][j] = (++ count);
            }

            for (int j = i + 1; j < row - 1 - i; j ++) {
                matrix[j][col - 1 - i] = (++ count);
            }

            if (row - 1 - i > i) {
                for (int j = col - 1 - i; j >= i; j --) {
                    matrix[row - 1 - i][j] = (++ count);
                }
                for (int j = row - 2 - i; j > i; j --) {
                    matrix[j][i] = (++ count);
                }
            }
        }

        return matrix;
    }
}