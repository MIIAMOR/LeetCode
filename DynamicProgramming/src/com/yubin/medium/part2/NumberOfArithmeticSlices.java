package com.yubin.medium.part2;

/**
 * 给定一个数组，求数组中连续且等差的子数组数量
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0;
        int count = 1, cap = Integer.MIN_VALUE;
        // 循环求取连续的等差数组，每一次求得一个等差连续数组，就让结果加上他的子数组数量
        for (int i = 0; i < nums.length; i++) {
            count++;
            if (i == nums.length - 1) {
                if (nums[i] - nums[i - 1] == cap)
                    res += numberOfSubarray(count);
                else res += numberOfSubarray(count - 1);
                break;
            }
            int dif = nums[i + 1] - nums[i];
            if (cap != dif) {
                res += numberOfSubarray(count);
                cap = dif;
                count = 1;
            }
        }
        return res;
    }

    /**
     * 求长度大于等于3的连续子数组的数量
     */
    private int numberOfSubarray(int n) {
        if (n < 3) return 0;
        int l = n - 2;
        return (l + 1) * l / 2;
    }

    public void test() {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, -1, 6, 7, 8, 9, 10, 12}));
    }

    public static void main(String[] args) {
        new NumberOfArithmeticSlices().test();
    }
}
