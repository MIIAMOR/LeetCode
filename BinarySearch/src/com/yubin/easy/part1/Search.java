package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/7/3 14:28
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
