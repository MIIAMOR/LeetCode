package com.yubin.medium.part3;

import java.util.*;

public class SubsetsWithDup {
    private List<List<Integer>> res = null;
    private List<Integer> list = null;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (index > nums.length) return;
        res.add(new ArrayList<>(list));
        int flag = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (flag == nums[i]) continue;
            flag = nums[i];
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
