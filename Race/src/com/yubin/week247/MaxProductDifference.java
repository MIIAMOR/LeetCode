package com.yubin.week247;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/6/27 10:47
 */
public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1]);
    }
}
