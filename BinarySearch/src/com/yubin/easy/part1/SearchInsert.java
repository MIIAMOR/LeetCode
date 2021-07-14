package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/7/3 15:19
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (right >= left) {
            mid = (right - left) / 2 + left;
            if (target > nums[mid]) left = mid + 1;
            else if (target < nums[mid]) right = mid - 1;
            else return mid;
        }
        return left;
    }
}
