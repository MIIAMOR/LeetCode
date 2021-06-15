package com.yubin.medium.part3;

import java.util.*;

public class CombinationSum2 {
    private List<Integer> list = null;
    private List<List<Integer>> res = null;
    private int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        int flag = 0;
        for (int i = index; i < candidates.length; i++) {
            if (flag == candidates[i]) continue;
            flag = candidates[i];
            sum += candidates[i];
            if (sum > target) {
                //i索引后面的数都会大于i索引的值，索引无需继续判断
                sum -= candidates[i];
                return;
            }
            list.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

    public void test() {
        for (List<Integer> integers : combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new CombinationSum2().test();
    }
}
