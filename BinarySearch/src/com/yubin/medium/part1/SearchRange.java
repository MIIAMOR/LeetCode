package com.yubin.medium.part1;

import java.util.Arrays;

public class SearchRange {
    /**
     * 由于数组有序,二分查找到target，然后向左右遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums.length == 0) return res;
        int left = 0, right = nums.length - 1;
        int mid = (right - left) / 2 + left;
        while (nums[mid] != target) {
            if (nums[right] == target) {
                mid = right;
                break;
            }
            if (nums[left] == target) {
                mid = left;
                break;
            }
            if (nums[mid] > target) {
                right = mid;
                mid = (right - left) / 2 + left;
            } else if (nums[mid] < target) {
                left = mid;
                mid = (right - left) / 2 + left;
            }
            if (right - left <= 1) return res;
        }
        left = mid;
        right = mid;
        while (left >= 0 && nums[left] == target) left--;
        while (right < nums.length && nums[right] == target) right++;
        res[0] = left + 1;
        res[1] = right - 1;
        return res;
    }


    public static void main(String[] args) {
        new SearchRange().test();
    }

    private void test() {
        int[] ints1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] ints2 = searchRange(new int[]{1}, 1);
        int[] ints3 = searchRange(new int[]{1, 4}, 4);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }
}