package com.yubin.medium.part1;

import java.util.Arrays;

public class FindKthLargest {
    /**
     * 直接排序索引
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 快速排序的变形算法
     */
    public int findKthLargest1(int[] nums, int k) {
        int index = nums.length - k;
        return findKthLargest(nums, 0, nums.length - 1, index);
    }

    private int findKthLargest(int[] nums, int left, int right, int index) {
        int mid = partition(nums, left, right);
        if (index == mid) return nums[mid];
        if (mid < index) return findKthLargest(nums, mid + 1, right, index);
        else return findKthLargest(nums, left, mid - 1, index);
    }

    private int partition(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] <= nums[right]) {
                int n = nums[i];
                nums[i] = nums[index];
                nums[index] = n;
                index++;
            }
        }
        return index - 1;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}