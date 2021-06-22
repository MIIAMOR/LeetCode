package com.yubin.medium.part2;

public class MaximalSquare {
    /**
     * dp数组中存放的是ij最大正方形的边长
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    int square;
                    square = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    square = Math.min(square, dp[i - 1][j - 1]);
                    dp[i][j] = square + matrix[i][j] - '0';
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res * res;
    }

    /**
     * 空间优化
     */
    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int pre = 0, curr = 0;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    curr = matrix[i][j] - '0';
                    dp[j] = curr;
                } else if (j == 0) {
                    curr = matrix[i][j] - '0';
                    pre = curr;
                } else {
                    if (matrix[i][j] == '1') {
                        curr = Math.min(dp[j - 1], dp[j]);
                        curr = Math.min(pre, curr) + matrix[i][j] - '0';
                    } else curr = 0;
                    dp[j - 1] = pre;
                    pre = curr;
                    if (j == n - 1) dp[j] = curr;
                }
                res = Math.max(curr, res);
            }
        }
        return res * res;
    }

    public void test() {
        maximalSquare(new char[][]{
                {'1', '0', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '1'}
        });
        maximalSquare1(new char[][]{
                {'1', '0'},
                {'0', '1'},
                {'0', '1'},
                {'0', '1'},
                {'1', '1'},
                {'0', '0'},
                {'0', '1'}
        });
        maximalSquare1(new char[][]{
                {'0'},
                {'1'}
        });
    }

    public static void main(String[] args) {
        new MaximalSquare().test();
    }
}
