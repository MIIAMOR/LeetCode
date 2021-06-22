package com.yubin.medium.part3;

/**
 * @author MIIAMOR
 * @date 2021/6/19
 */
public class LongestCommonSubsequence {
    /**
     * dp[i][j]表示的是chars1[1...i]和chars2[1...j]中最长子序列的长度
     * 当遇到相同字母的时候dp[i][j] = dp[i - 1][j - 1] + 1;
     * 遇到不同的字符时：就是dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1, chars2;
        int len1 = text1.length(), len2 = text2.length();
        chars1 = text1.toCharArray();
        chars2 = text2.toCharArray();
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (chars1[j - 1] == chars2[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len2][len1];
    }

    /**
     * 空间优化
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] chars1, chars2;
        int len1 = text1.length(), len2 = text2.length();
        chars1 = text1.toCharArray();
        chars2 = text2.toCharArray();
        int[] dp = new int[len1 + 1];
        int curr, pre;
        for (int i = 1; i <= len2; i++) {
            curr = 0;
            pre = 0;
            for (int j = 1; j <= len1; j++) {
                if (chars1[j - 1] == chars2[i - 1]) {
                    curr = dp[j - 1] + 1;
                } else {
                    curr = Math.max(curr, dp[j]);
                }
                dp[j - 1] = pre;
                pre = curr;
                if (j == len1) dp[len1] = curr;
            }
        }
        return dp[len1];
    }
}
