package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/22
 */
class NumArray {
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    private int[] dp = null;

    public NumArray(int[] nums) {
        int len = nums.length;
        dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        int res = 0;
        res = dp[right + 1] - dp[left];
        return res;
    }
}