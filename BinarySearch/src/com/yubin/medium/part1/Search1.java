package com.yubin.medium.part1;

public class Search1 {
    /**
     * 二分求解：在反转的排序数组中找到target的索引
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            //数组被分为两个有序的部分，首先需要确定的是mid所处的地方左侧异或右侧是否局部有序
            if (nums[mid] < nums[nums.length - 1]) {
                //mid的右侧局部有序,此时判断target的位置
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else right = mid - 1;
            } else {
                //mid的左侧局部有序，此时判断target的位置
                if (target < nums[mid] && target >= nums[0]) {
                    right = mid - 1;
                } else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Search1().test();
    }

    private void test() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{1, 3}, 3));
    }
}