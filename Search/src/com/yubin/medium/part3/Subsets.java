package com.yubin.medium.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res = null;
    private List<Integer> list = null;

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (index > nums.length) return;
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public void test() {
        for (List<Integer> subset : subsets(new int[]{1, 2, 3, 4})) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Subsets().test();
    }
}
