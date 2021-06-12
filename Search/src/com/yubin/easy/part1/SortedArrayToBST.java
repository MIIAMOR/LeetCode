package com.yubin.easy.part1;

import com.yubin.TreeNode;

public class SortedArrayToBST {
    /**
     * 自顶向下构建
     * 以中间的数为根，数组左侧构建左子树，数组右侧构建右子树
     * dfs递归求解
     */
    private TreeNode dfsUTB(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsUTB(nums, left, mid - 1);
        root.right = dfsUTB(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfsUTB(nums, 0, nums.length - 1);
    }

    /**
     * 自底向上构建
     */
    private int index = 0;

    private TreeNode dfsBTU(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode leftNode = dfsBTU(nums, left, mid - 1);
        TreeNode tree = new TreeNode(nums[index++]);
        TreeNode rightNode = dfsBTU(nums, mid + 1, right);
        tree.left = leftNode;
        tree.right = rightNode;
        return tree;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        return dfsBTU(nums, 0, nums.length - 1);
    }
}