package com.yubin.week249;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:06
 */
public class GetConcatenation {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int len = nums.length;
            int[] res = new int[2 * len];
            for (int i = 0; i < len; i++) {
                res[i] = res[i + len] = nums[i];
            }
            return res;
        }
    }
}
