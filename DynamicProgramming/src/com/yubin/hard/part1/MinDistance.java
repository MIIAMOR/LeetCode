package com.yubin.hard.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/21
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 对于字符串长度为0的情况，只能选择删除后者添加的情况
                if (i == 0) dp[0][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    // 对于遇到相等的情况 步数不会增加
                    if (chars1[i - 1] == chars2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                    else {
                        // 多种情况来考虑
                        // 直接改变这个字符为目标字符
                        // 异或 删除原字符串末尾字符
                        // 异或 在原字符串上添加指定字符
                        // 这三种情况的初始状态不一样 注意状态转移过程的初始状态判断
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int[] currDp = new int[n + 1], preDp = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                preDp[j] = currDp[j];
                // 对于字符串长度为0的情况，只能选择删除后者添加的情况
                if (i == 0) currDp[j] = j;
                else if (j == 0) currDp[j] = i;
                else {
                    // 对于遇到相等的情况 步数不会增加
                    if (chars1[i - 1] == chars2[j - 1]) currDp[j] = preDp[j - 1];
                    else {
                        // 多种情况来考虑
                        // 直接改变这个字符为目标字符
                        // 异或 删除原字符串末尾字符
                        // 异或 在原字符串上添加指定字符
                        // 这三种情况的初始状态不一样 注意状态转移过程的初始状态判断
                        currDp[j] = Math.min(preDp[j], currDp[j - 1]) + 1;
                        currDp[j] = Math.min(currDp[j], preDp[j - 1] + 1);
                    }
                }
            }
        }
        return currDp[n];
    }
}
