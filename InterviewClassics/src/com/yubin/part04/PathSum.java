package com.yubin.part04;

import com.yubin.basic.TreeNode;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/6/28 12:08
 */
public class PathSum {
    private int res;

    public int pathSum(TreeNode root, int sum) {
        return pathSum1(root, sum);
//        return pathSum2(root, sum);
//        return pathSum3(root, sum);
    }

    public int pathSum1(TreeNode root, int sum) {
        res = 0;
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        getSum(root, 0, sum);
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    private void getSum(TreeNode node, int currSum, int sum) {
        if (node == null) return;
        currSum += node.val;
        if (currSum == sum) res++;
        getSum(node.left, currSum, sum);
        getSum(node.right, currSum, sum);
    }

    /**
     * 记忆化搜索
     */
    public int pathSum2(TreeNode root, int sum) {
        res = 0;
        getSum(root, sum);
        return res;
    }

    private List<Integer> getSum(TreeNode node, int sum) {
        if (node == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> left = getSum(node.left, sum);
        List<Integer> right = getSum(node.right, sum);
        for (Integer i : left) {
            list.add(i + node.val);
            if (i + node.val == sum) res++;
        }
        for (Integer i : right) {
            list.add(i + node.val);
            if (i + node.val == sum) res++;
        }
        list.add(node.val);
        if (node.val == sum) res++;
        return list;
    }

    /**
     * 记忆化搜索
     */
    private Map<TreeNode, List<Integer>> record;// 用记录节点为起始点可能计算出的路径和

    public int pathSum3(TreeNode root, int sum) {
        record = new HashMap<>();
        record.put(null, new ArrayList<>());
        res = 0;
        backtracking(root, sum);
        return res;
    }

    private void backtracking(TreeNode node, int sum) {
        if (node == null) return;
        backtracking(node.left, sum);
        backtracking(node.right, sum);
        getSum(node);
        List<Integer> list = record.get(node);
        for (Integer currSum : list) {
            if (currSum == sum) res++;
        }
    }

    private void getSum(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        List<Integer> left = record.get(node.left);
        List<Integer> right = record.get(node.right);
        for (Integer i : left) {
            list.add(i + node.val);
        }
        for (Integer i : right) {
            list.add(i + node.val);
        }
        list.add(node.val);
        record.put(node, list);
    }
}