package com.yubin.medium.part3;

import java.util.Arrays;

public class LengthOfLIS {
    /**
     * O(n^2)
     */
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 使用二分搜索降低时间复杂度
     */
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size + 1];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                int right = len - 1;
                for (int index = 0; index <= right; index++) {
                    if (dp[index] >= nums[i]) {
                        dp[index] = nums[i];
                        break;
                    }
                    if (index == right) dp[index] = nums[i];
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        new LengthOfLIS().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        new LengthOfLIS().lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12});
        new LengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }
}