package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/7/4 14:43
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right]))
                res[index--] = nums[right] * nums[right--];
            else
                res[index--] = nums[left] * nums[left++];
        }
        return res;
    }
}
