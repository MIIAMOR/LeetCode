package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/7/1 20:45
 */
public class CountEval {
    /**
     * dp[i][j][0]代表第i个字符到第j个字符，result=0的可能性个数
     * <p>
     * dp[i][j][1]代表第i个字符到第j个字符，result=1的可能性个数
     * <p>
     * 链接：https://leetcode-cn.com/problems/boolean-evaluation-lcci/solution/c-qu-jian-dphe-xin-fang-cheng-jian-dan-c-13kh/
     */
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        char[] chars = s.toCharArray();
        // 初始化
        for (int i = 0; i < n; i += 2) {
            int z = chars[i] == '0' ? 1 : 0;
            dp[i][i][0] = z;
            dp[i][i][1] = 1 - z;
        }
        for (int step = 2; step < n; step += 2) {
            for (int i = 0; i + step < n; i += 2) {
                for (int j = i + 1; j < i + step; j += 2) {
                    int left0 = dp[i][j - 1][0], left1 = dp[i][j - 1][1];
                    int right0 = dp[j + 1][i + step][0], right1 = dp[j + 1][i + step][1];
                    switch (chars[j]) {
                        case '&' -> {
                            dp[i][i + step][1] += left1 * right1;
                            dp[i][i + step][0] += left0 * right0 + left0 * right1 + left1 * right0;
                        }
                        case '|' -> {
                            dp[i][i + step][0] += left0 * right0;
                            dp[i][i + step][1] += left0 * right1 + left1 * right0 + left1 * right1;
                        }
                        case '^' -> {
                            dp[i][i + step][0] += left0 * right0 + left1 * right1;
                            dp[i][i + step][1] += left1 * right0 + left0 * right1;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }
}
