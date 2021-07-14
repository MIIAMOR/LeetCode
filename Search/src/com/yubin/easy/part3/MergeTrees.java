package com.yubin.easy.part3;

import com.yubin.basic.TreeNode;

/**
 * @author MIIAMOR
 * @date 2021/7/10 21:11
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return new TreeNode(root1.val + root2.val,
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right));
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode l1 = null, r1 = null, l2 = null, r2 = null;
        int n = 0;
        if (root1 != null) {
            n += root1.val;
            l1 = root1.left;
            r1 = root1.right;
        }
        if (root2 != null) {
            n += root2.val;
            l2 = root2.left;
            r2 = root2.right;
        }
        return new TreeNode(n, mergeTrees(l1, l2), mergeTrees(r1, r2));
    }
}
