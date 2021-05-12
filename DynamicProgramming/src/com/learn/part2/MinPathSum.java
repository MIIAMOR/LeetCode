package com.learn.part2;

public class MinPathSum {
    /**
     * 动态规划算法，当前点的最短路径等于左边和上边的点中的较小值加上自己
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else if (i > 0)
                    dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划优化空间复杂度,只维护行数据
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] currRow = new int[n];
        int[] preRow = new int[n];
        currRow[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) currRow[j] = grid[i][j] + currRow[j - 1];
                else if (j == 0 && i > 0) currRow[j] = grid[i][j] + preRow[j];
                else if (i > 0) currRow[j] = Math.min(grid[i][j] + currRow[j - 1], grid[i][j] + preRow[j]);
            }
            System.arraycopy(currRow, 0, preRow, 0, n);
        }
        return currRow[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        MinPathSum mps = new MinPathSum();
        System.out.println(mps.minPathSum1(grid));
        System.out.println(mps.minPathSum2(grid));
        System.out.println(mps.minPathSum1(grid2));
        System.out.println(mps.minPathSum2(grid2));
    }
}
