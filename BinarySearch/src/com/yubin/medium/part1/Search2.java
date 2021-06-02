package com.yubin.medium.part1;

public class Search2 {
    /**
     * 暴力枚举法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return true;
        }
        return false;
    }

    /**
     * 二分查找算法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[left] == target || nums[right] == target || nums[mid] == target) return true;
            if (nums[left] == nums[mid]) left++;
            else if (nums[mid] <= nums[right]) {
                //右区间是有序的
                if (target > nums[mid] && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[left]) {
                //左侧区间是有序的
                if (target > nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Search2().test();
    }

    private void test() {
        System.out.println(search1(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search1(new int[]{0, 0, 1, 1, 2, 0}, 2));
    }
}
