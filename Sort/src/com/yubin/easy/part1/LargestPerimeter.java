package com.yubin.easy.part1;

import java.util.Arrays;

public class LargestPerimeter {
    /**
     * 返回可能组合出的最大周长
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    public void test() {
        System.out.println(largestPerimeter(new int[]{1, 3, 3}));
    }

    public static void main(String[] args) {
        new LargestPerimeter().test();
    }
}