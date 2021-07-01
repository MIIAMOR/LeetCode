package com.yubin.part04;

import com.yubin.basic.TreeNode;

/**
 * @author MIIAMOR
 * @date 2021/6/27 14:20
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left)
                && isBalanced(root.right)
                && (Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1);
    }

    private int treeHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
    }
}
