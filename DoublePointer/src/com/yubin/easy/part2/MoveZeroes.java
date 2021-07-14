package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/7/5 13:49
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int[] numsTmp = new int[nums.length];
        System.arraycopy(nums, 0, numsTmp, 0, nums.length);
        int left = 0, right = nums.length - 1;
        for (int j : numsTmp) {
            if (j == 0) nums[right--] = j;
            else nums[left++] = j;
        }
    }

    public void moveZeroes1(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) swap(nums, left++, right);
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
