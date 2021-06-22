package com.yubin.medium.part2;


public class NumSquares {
    /**
     * dp[i]表示数字i最少可以用
     */
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 10000;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 利用数学知识解题（四平方和定理）
     */
    public int numSquares(int n) {
        // 第一步：判断是否是完全平方数
        if (isSquares(n)) return 1;
        // 第二步：判断是否可以有两个完全平方数相加得到
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            int num = n - i * i;
            if (isSquares(num)) return 2;
        }
        // 第三步：判断是否可以有四个完全平方数相加得来
        if (isSquaresOfFour(n)) return 4;
        return 3;
    }

    /**
     * n = 4^k*(8*m+7)
     */
    private boolean isSquaresOfFour(int n) {
        while (n % 4 == 0) n /= 4;
        return n % 8 == 7;
    }

    private boolean isSquares(int n) {
        int i = (int) Math.sqrt(n);
        return i * i == n;
    }


    public static void main(String[] args) {
        new NumSquares().numSquares1(12);
    }
}
