public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int n = obstacleGrid.length;
        if (n <= 0) {
            return 0;
        }

        int m = obstacleGrid[0].length;
        if (m <= 0) {
            return 0;
        }

        if (obstacleGrid[0][0] != 0) {
            return 0;
        }
        int[][] cached = new int[m][n];
        return uniquePathsInternal(m, n, cached, obstacleGrid);

    }

    public int uniquePathsInternal(int m, int n, int[][] cached, int[][] obstacleGrid) {
        if (obstacleGrid[n - 1][m - 1] != 0) {
            cached[m - 1][n - 1] = -1;
            return 0;
        }
        
        if (cached[m - 1][n - 1] == -1) {
            return 0;
        }

        if (cached[m - 1][n - 1] > 0) {
            return cached[m - 1][n - 1];
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            cached[m - 1][n - 1] = 1;
            return 1;
        }
        int sum = uniquePathsInternal(m - 1, n, cached, obstacleGrid) + uniquePathsInternal(m, n - 1, cached, obstacleGrid);
        cached[m - 1][n - 1] = sum;
        return sum;
    }
}