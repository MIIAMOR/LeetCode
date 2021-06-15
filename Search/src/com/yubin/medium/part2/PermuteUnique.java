package com.yubin.medium.part2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
    private List<Integer> list = null;
    private List<List<Integer>> res = null;
    private int size = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new LinkedList<>();
        res = new LinkedList<>();
        int len = nums.length;
        size = 0;
        Arrays.sort(nums);
        backtracking(nums, len);
        return res;
    }

    private void backtracking(int[] nums, int n) {
        if (size == n) {
            res.add(new LinkedList<>(list));
            return;
        }
        int flag = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == flag || nums[i] == Integer.MIN_VALUE) continue;
            int num = nums[i];
            flag = num;
            nums[i] = Integer.MIN_VALUE;
            list.add(num);
            size++;
            backtracking(nums, n);
            list.remove(list.size() - 1);
            size--;
            nums[i] = num;
        }
    }

    public void test() {
        for (List<Integer> integers : permuteUnique(new int[]{1, 1, 2})) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (List<Integer> integers : permuteUnique(new int[]{1, 3, 2})) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new PermuteUnique().test();
    }
}