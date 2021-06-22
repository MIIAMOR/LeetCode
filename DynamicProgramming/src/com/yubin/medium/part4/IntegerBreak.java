package com.yubin.medium.part4;

/**
 * @author MIIAMOR
 * @date 2021/6/19
 */
public class IntegerBreak {
    /**
     * dp[i] 表示加起来最多为i的数所能达到的最大乘积
     * 状态转移方程dp[i]=max(dp[j]*(i-j),dp[j-1]*(i-j+1)......)
     * 注意特殊情况
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = i;
            // 计算的时候算一般就行，例如dp[7]*3 > dp[3]*7恒成立
            for (int j = i - 1; j >= i / 2; j--) {
                max = Math.max(dp[j] * (i - j), max);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(10));
    }
}
