package com.yubin.medium.part4;

/**
 * @author MIIAMOR
 * @date 2021/6/20
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        // 这里的dp[i][j]表示的是word1前i个字符变换到word2前j个字符最少的步骤数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    // 递推方程分情况考虑
                    if (chars1[i - 1] == chars2[j - 1]) {
                        // 1. i和j索引处的单词相等
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 2. i和j处索引的单词不相等
                        // 此时再细分情况:
                        // 直接添加字符即可(1步操作) -->包含：删除后再添加字符(2步操作)情况 删除到达dp[i-1][j]状态
                        // 异或 直接删除i处的字符
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 空间优化
     */
    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int[] preDp = new int[n + 1];
        int[] currDp = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                preDp[j] = currDp[j];
                if (i == 0) currDp[j] = j;
                else if (j == 0) currDp[0] = i;
                else {
                    if (chars1[i - 1] == chars2[j - 1]) currDp[j] = preDp[j - 1];
                    else
                        currDp[j] = Math.min(preDp[j], currDp[j - 1]) + 1;
                }
            }
        }
        return currDp[n];
    }

    public static void main(String[] args) {
        new MinDistance().minDistance1("sea", "eat");
        new MinDistance().minDistance("sea", "eat");
    }
}
