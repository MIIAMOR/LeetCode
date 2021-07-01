package com.yubin.part04;

import com.yubin.basic.TreeNode;

/**
 * @author MIIAMOR
 * @date 2021/6/28 11:28
 */
public class CheckSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return findTree(t1, t2);
    }

    private boolean findTree(TreeNode root, TreeNode target) {
        if (root == target) return true;
        if (root == null) return false;
        if (root.val == target.val && checkTree(root, target)) return true;
        return findTree(root.left, target) || findTree(root.right, target);
    }

    private boolean checkTree(TreeNode t1, TreeNode t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return checkTree(t1.left, t2.left) && checkTree(t1.right, t2.right);
    }
}