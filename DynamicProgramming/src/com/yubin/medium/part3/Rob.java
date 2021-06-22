package com.yubin.medium.part3;

/**
 * @author MIIAMOR
 * @date 2021/6/19
 */
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        else if (len == 2) return Math.max(nums[0], nums[1]);
        else if (len == 3) {
            int max = Math.max(nums[0], nums[1]);
            return Math.max(max, nums[2]);
        }
        // 正向偷
        int[] stealPos = new int[len];
        int[] leavePos = new int[len];
        stealPos[1] = nums[1];
        // 反向偷
        int[] stealNeg = new int[len];
        int[] leaveNeg = new int[len];
        stealNeg[1] = nums[len - 2];
        for (int i = 2; i < len; i++) {
            leavePos[i] = Math.max(stealPos[i - 1], leavePos[i - 1]);
            stealPos[i] = Math.max(leavePos[i - 1], stealPos[i - 2]) + nums[i];

            leaveNeg[i] = Math.max(stealNeg[i - 1], leaveNeg[i - 1]);
            stealNeg[i] = Math.max(leaveNeg[i - 1], stealNeg[i - 2]) + nums[len - i - 1];
        }
        int pos = Math.max(stealPos[len - 1], leavePos[len - 1]);
        int neg = Math.max(stealNeg[len - 1], leaveNeg[len - 1]);
        return Math.max(pos, neg);
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 1, 1, 2}));
    }
}
