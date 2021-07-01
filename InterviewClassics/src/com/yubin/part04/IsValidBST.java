package com.yubin.part04;

import com.yubin.basic.TreeNode;

/**
 * @author MIIAMOR
 * @date 2021/6/27 14:32
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        // 这里默认相同的数据可以充当左子树
        return root.val >= min && root.val < max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}
