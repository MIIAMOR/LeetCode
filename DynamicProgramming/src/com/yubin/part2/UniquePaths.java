package com.yubin.part2;

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
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        //递推求解数组中的每个值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划算法空间优化<br>
     * 遍历得时候按照行进行遍历，那么只需要记录上一行和当前点的左边即可
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] preRow = new int[n];
        int[] currRow = new int[n];
        currRow[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0) currRow[j] = 1;
                else currRow[j] = preRow[j] + currRow[j - 1];
            }
            System.arraycopy(currRow, 0, preRow, 0, n);
        }
        return currRow[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths1(3, 7));
    }
}
