package com.yubin.easy.part1;

public class SortArrayByParityII {
    /**
     * 双指针解法
     */
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1, even = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[even] = num;
                even += 2;
            } else {
                res[odd] = num;
                odd += 2;
            }
        }
        return res;
    }

    public void test() {
        int[] res = sortArrayByParityII(new int[]{1, 2, 3, 6});
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static void main(String[] args) {
        new SortArrayByParityII().test();
    }
}
