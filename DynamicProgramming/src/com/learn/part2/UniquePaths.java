package com.learn.part2;

public class UniquePaths {
    /**
     * 动态规划算法求取最多的路径数量<br>
     * 递推关系，对于最终的目的点，由于只能选择右或者下，最后只有两个地方直接抵达这个点<br>
     * 即改点的上一个点或者左边的那个点，由此得到递推关系dp[i][j]=dp[i-1][j]+dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化左边以及上边的边界值
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        //递推求解数组中的每个值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7));
    }
}
