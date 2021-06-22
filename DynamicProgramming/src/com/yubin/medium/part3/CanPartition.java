package com.yubin.medium.part3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MIIAMOR
 * @date 2021/6/19
 */
public class CanPartition {
    /**
     * 0-1背包问题 halfSum为背包值的最大容量 nums.length为物品数量 nums[i]为物品的值
     */
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) return false;
        int len = nums.length;
        int halfSum = sum / 2;
        int[][] dp = new int[len + 1][halfSum + 1];
        // dp[i][j]表示的是取前i个数，最大只能达到j的最大值
        for (int i = 1; i < len + 1; i++) {
            int num = nums[i - 1];
            for (int j = 1; j < halfSum + 1; j++) {
                if (j >= num) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + num);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j == halfSum && dp[i][j] == halfSum) return true;
            }
        }
        return false;
    }

    /**
     * 空间优化
     */
    public boolean canPartition1(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) return false;
        int len = nums.length;
        int halfSum = sum / 2;
        int[] dp = new int[halfSum + 1];
        for (int i = 1; i < len + 1; i++) {
            int num = nums[i - 1];
            for (int j = halfSum; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
            if (dp[halfSum] == halfSum) return true;
        }
        return false;
    }

    /**
     * dfs搜索 dfs数记忆化搜索（记忆对象是index和currSum）
     */
    private Map<String, Boolean> ms = null;

    public boolean canPartition2(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        ms = new HashMap<>();
        return dfs(nums, halfSum, 0, 0);
    }

    private boolean dfs(int[] nums, int halfSum, int sum, int index) {
        if (index >= nums.length) return false;

        if (sum == halfSum) return true;

        if (sum > halfSum) return false;

        String key = sum + "&" + index;
        if (ms.containsKey(key)) return ms.get(key);

        boolean res = dfs(nums, halfSum, sum, index + 1) || dfs(nums, halfSum, sum + nums[index], index + 1);

        ms.put(key, res);

        return res;
    }

    private int getSum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        CanPartition c = new CanPartition();
        System.out.println(c.canPartition1(new int[]{1, 2, 5}));
        System.out.println(c.canPartition(new int[]{1, 5, 10, 6}));
        System.out.println(c.canPartition1(new int[]{1, 5, 10, 6}));
        System.out.println(c.canPartition2(new int[]{1, 5, 10, 6}));
        System.out.println(c.canPartition2(new int[]{1, 5, 11, 5}));
        System.out.println(c.canPartition2(new int[]{
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97
        }));
    }
}
