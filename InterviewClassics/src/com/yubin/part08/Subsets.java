package com.yubin.part08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/30 10:44
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
//        return subsets1(nums);
        return subsets2(nums);
    }

    /**
     * 方案1：dfs搜索
     */
    private List<List<Integer>> res;
    private List<Integer> list;

    private List<List<Integer>> subsets1(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 方案2，动态规划算法
     */
    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}
