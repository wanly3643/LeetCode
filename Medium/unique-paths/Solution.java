public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cached = new int[m][n];
        return uniquePathsInternal(m, n, cached);

    }

    public int uniquePathsInternal(int m, int n, int[][] cached) {
        if (cached[m - 1][n - 1] != 0) {
            return cached[m - 1][n - 1];
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            cached[m - 1][n - 1] = 1;
            return 1;
        }
        int sum = uniquePathsInternal(m - 1, n, cached) + uniquePathsInternal(m, n - 1, cached);
        cached[m - 1][n - 1] = sum;
        return sum;
    }
}