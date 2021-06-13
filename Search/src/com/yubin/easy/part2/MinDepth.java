package com.yubin.easy.part2;

import com.yubin.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MinDepth {
    /**
     * 层序遍历思想
     */
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        int depth = 1;
        while (true) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = level.remove(0);
                if (tree != null) {
                    if (tree.left == null && tree.right == null) return depth;
                    else {
                        level.add(tree.left);
                        level.add(tree.right);
                    }
                }
            }
            depth++;
        }
    }

    /**
     * dfs求解方法
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthOfNode(root);
    }

    private int minDepthOfNode(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.min(minDepthOfNode(root.left), minDepthOfNode(root.right));
    }

    public void test() {
        System.out.println("em...");
    }

    public static void main(String[] args) {
        new MinDepth().test();
    }
}