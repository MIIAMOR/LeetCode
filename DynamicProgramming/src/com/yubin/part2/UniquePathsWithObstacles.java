package com.yubin.part2;

public class UniquePathsWithObstacles {

    /**
     * 动态规划算法求取最多的路径数量<br>
     * 递推关系，对于最终的目的点，由于只能选择右或者下，最后只有两个地方直接抵达这个点<br>
     * 即改点的上一个点或者左边的那个点，由此得到递推关系dp[i][j]=dp[i-1][j]+dp[i][j-1]<br>
     * 但是，由于中间有不可过的点，那么这个位置的dp值置0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (i == 1 && j == 1) dp[i][j] = obstacleGrid[0][0] == 0 ? 1 : 0;
                else {
                    if (obstacleGrid[i - 1][j - 1] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    else dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 对动态规划算法进行空间优化
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] preRow = new int[n];
        int[] currRow = new int[n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    //第一行
                    if (obstacleGrid[i][j] == 1) {
                        flag = true;
                        currRow[j] = 0;
                    } else if (obstacleGrid[i][j] == 0 && flag == false) {
                        currRow[j] = 1;
                    } else if (flag) {
                        currRow[j] = 0;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 1) currRow[0] = 0;
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        currRow[j] = 0;
                    } else {
                        currRow[j] = preRow[j] + currRow[j - 1];
                    }
                }
            }
            System.arraycopy(currRow, 0, preRow, 0, n);
        }
        return currRow[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles upo = new UniquePathsWithObstacles();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(upo.uniquePathsWithObstacles1(grid));
        System.out.println(upo.uniquePathsWithObstacles2(grid));
    }
}