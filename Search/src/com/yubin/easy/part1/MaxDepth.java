package com.yubin.easy.part1;

import com.yubin.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MaxDepth {
    /**
     * 基于层析遍历思想
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> level = new LinkedList<>();
        int depth = 0;
        level.add(root);
        while (true) {
            int count = 0, size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = level.remove(0);
                TreeNode left = tree.left;
                TreeNode right = tree.right;
                if (left == null)
                    count++;
                else level.add(left);
                if (right == null)
                    count++;
                else level.add(right);
            }
            depth++;
            if (count == size * 2) return depth;
        }
    }

    /**
     * 求最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    private int depth = 0;
    private int maxDepth = 0;

    /**
     * 求最大深度
     */
    public int maxDepth1(TreeNode root) {
        dfs(root);
        return maxDepth;
    }

    private void dfs(TreeNode root) {
        depth++;
        if (root == null) {
            depth--;
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        dfs(root.left);
        dfs(root.right);
        depth--;
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth2(root));
    }

    public static void main(String[] args) {
        new MaxDepth().test();
    }
}