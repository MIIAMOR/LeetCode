package com.yubin.medium.part2;

import java.util.LinkedList;
import java.util.List;

public class Combine {
    /**
     * 回溯法
     */
    private List<List<Integer>> res = null;
    private List<Integer> combineNum = null;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        combineNum = new LinkedList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtracking(nums, k, 0);
        return res;
    }

    private void backtracking(int[] nums, int k, int beginIndex) {
        if (combineNum.size() == k) {
            res.add(new LinkedList<>(combineNum));
            return;
        }
        for (int i = beginIndex; i < nums.length; i++) {
            combineNum.add(nums[i]);
            backtracking(nums, k, i + 1);
            combineNum.remove(combineNum.size() - 1);
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        res = new LinkedList<>();
        combineNum = new LinkedList<>();
        backtracking1(n, k, 0);
        return res;
    }

    /**
     * 回溯算法 剪枝去除不必要的计算
     *
     * @param n          组合中的数去1...n
     * @param k          k表示当前还需要多少个数来组合
     * @param beginIndex 下一个数从哪个位置开始寻找
     */
    private void backtracking1(int n, int k, int beginIndex) {
        if (0 == k) {
            res.add(new LinkedList<>(combineNum));
            return;
        }
        for (int i = beginIndex; i < n - k + 1; i++) {
            combineNum.add(i + 1);
            backtracking1(n, k - 1, i + 1);
            combineNum.remove(combineNum.size() - 1);
        }
    }

    public void test() {
        combine(4, 2);
    }

    public static void main(String[] args) {
        new Combine().test();
    }
}