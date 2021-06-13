package com.yubin.medium.part2;

import java.util.*;

public class Permute {
    private List<List<Integer>> res = null;
    private int len = 0;
    private List<Integer> list = null;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        list = new LinkedList<>();
        len = nums.length;
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == Integer.MIN_VALUE) {
                count++;
                continue;
            }
            list.add(num);
            nums[i] = Integer.MIN_VALUE;
            backtracking(nums);
            list.remove(list.size() - 1);
            nums[i] = num;
        }
        if (count == len) {
            res.add(new LinkedList<>(list));
        }
    }

    public void test() {
        permute(new int[]{1, 2, 3});
    }

    public static void main(String[] args) {
        new Permute().test();
    }
}