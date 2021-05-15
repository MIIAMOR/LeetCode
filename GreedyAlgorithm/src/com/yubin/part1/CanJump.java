package com.yubin.part1;

public class CanJump {
    /**
     * 判断是否可以达到最后的一个点，只需要判断i（索引）+i对应的值是否可以大于最后一个位置的索引即可
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res = Math.max(i + nums[i], res);
            } else {
                if (res <= i) return false;
            }
            if (res >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
        int[] nums1 = new int[]{3, 2, 1, 1, 4};
        int[] nums2 = new int[]{3, 2, 1, 0, 4};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{2, 0, 0};
        System.out.println(cj.canJump(nums1));
        System.out.println(cj.canJump(nums2));
        System.out.println(cj.canJump(nums3));
        System.out.println(cj.canJump(nums4));
    }
}
