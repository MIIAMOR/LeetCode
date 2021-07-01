package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/6/29 23:57
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return -1;
    }
}
