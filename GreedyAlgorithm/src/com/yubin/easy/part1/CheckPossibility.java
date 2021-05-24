package com.yubin.easy.part1;

public class CheckPossibility {
    /**
     * count用于记录修改的次数
     * 选择怎么修改的时候，一定要根据已知条件把数修改为符合题意的最低要求
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int currMin = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                currMin = nums[i];
                continue;
            }
            //修改一个数，使他变成变成满足条件的最小数
            if (currMin <= nums[i + 1]) nums[i] = currMin;
            else nums[i + 1] = nums[i];
            count++;
            if (count > 1) return false;
        }
        return true;
    }

    public void test() {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
    }

    public static void main(String[] args) {
        new CheckPossibility().test();
    }
}
