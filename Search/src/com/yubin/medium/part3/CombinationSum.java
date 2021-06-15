package com.yubin.medium.part3;

import java.util.*;

public class CombinationSum {
    private List<Integer> list = null;
    private List<List<Integer>> res = null;
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        res = new LinkedList<>();
        Arrays.sort(candidates);
        sum = 0;
        backtracking(candidates, target, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                //i索引后面的数都会大于i索引的值，索引无需继续判断
                sum -= candidates[i];
                return;
            }
            list.add(candidates[i]);
            backtracking(candidates, target, i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
