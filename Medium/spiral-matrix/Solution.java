public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> all = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return all;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int mid = (Math.min(row, col) - 1) / 2;
        for (int i = 0; i <= mid; i ++) {
            for (int j = i; j <= col - 1 - i; j ++) {
                all.add(matrix[i][j]);
            }

            for (int j = i + 1; j < row - 1 - i; j ++) {
                all.add(matrix[j][col - 1 - i]);
            }

            if (row - 1 - i > i) {
                for (int j = col - 1 - i; j >= i; j --) {
                    all.add(matrix[row - 1 - i][j]);
                }
            }

            if (i < col - 1 - i) {
                for (int j = row - 2 - i; j > i; j --) {
                    all.add(matrix[j][i]);
                }
            }
        }

        return all;
    }
}