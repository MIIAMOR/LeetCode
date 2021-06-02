package com.yubin.medium.part1;

public class FindMin1 {
    /**
     * 暴力遍历
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }

    /**
     * 按照题目中的交换规则
     * 数组局部有序
     *
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            min = Math.min(nums[mid], min);
            if (nums[mid] < nums[nums.length - 1]) {
                //右侧局部有序，更小的数在左侧
                right = mid - 1;
            } else {
                //左侧局部有序，更小的数在右侧
                left = mid + 1;
            }
        }
        return min;
    }

    public void test() {
        System.out.println(findMin1(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin1(new int[]{3, 1, 2}));
    }

    public static void main(String[] args) {
        new FindMin1().test();
    }
}