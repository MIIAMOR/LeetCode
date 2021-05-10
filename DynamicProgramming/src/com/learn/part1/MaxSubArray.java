package com.learn.part1;

public class MaxSubArray {
    /**
     * 动态规划算法<br>
     * 利用一个一维数组dp[j]来记录包含nums[j]的最大子序和<br/>
     * 其中递归规律是：<br>
     * 1.对于dp[j],如果dp[j-1]>0,那么dp[j]=dp[j-1]+nums[j]<br>
     * 2.对于dp[j],如果dp[j-1]<0，那么dp[j]=nums[j]
     *
     * @param nums 一个数组
     * @return 最大子序和（即最大连续子数组和）
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        //按照递推规律求得dp数组的值
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(msa.maxSubArray1(nums));
    }
}
