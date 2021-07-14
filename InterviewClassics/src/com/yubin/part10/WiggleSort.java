package com.yubin.part10;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/7/8 18:43
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] numsTmp = Arrays.copyOf(nums, nums.length);
        boolean flag = true;
        int left = 0, right = numsTmp.length - 1;
        int index = 0;
        while (left <= right) {
            if (flag) {
                nums[index++] = numsTmp[right--];
            } else nums[index++] = numsTmp[left++];
            flag = !flag;
        }
    }
}
