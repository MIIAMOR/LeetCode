package com.yubin.medium.part1;

import com.yubin.basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        index = 0;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfs(preorder, indexMap, 0, indexMap.size() - 1);
    }

    private TreeNode dfs(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) return null;
        int node = preorder[index];
        index++;
        TreeNode tree = new TreeNode(node);
        int inorderIndex = map.get(node);
        tree.left = dfs(preorder, map, left, inorderIndex - 1);
        tree.right = dfs(preorder, map, inorderIndex + 1, right);
        return tree;
    }

    public void test() {
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(root.left.val);
    }

    public static void main(String[] args) {
        new BuildTree().test();
    }
}
