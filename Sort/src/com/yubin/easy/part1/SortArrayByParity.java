package com.yubin.easy.part1;

public class SortArrayByParity {
    /**
     * 双指针思想
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) res[left++] = num;
            else res[right--] = num;
        }
        return res;
    }

    public void test() {
        int[] res = sortArrayByParity(new int[]{1, 2, 3, 6});
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static void main(String[] args) {
        new SortArrayByParity().test();
    }
}
