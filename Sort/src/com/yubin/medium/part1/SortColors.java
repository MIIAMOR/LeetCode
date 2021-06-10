package com.yubin.medium.part1;

import java.util.Arrays;

public class SortColors {
    /**
     * 这题真离谱
     */
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 计数排序
     */
    public void sortColors1(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
