package com.yubin.week248;

/**
 * @author MIIAMOR
 * @date 2021/7/4 18:50
 */
public class BuildArray {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
