package com.yubin.part04;

import com.yubin.basic.TreeNode;

/**
 * @author MIIAMOR
 * @date 2021/6/27 19:45
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 两边同时为null的情况，在前两种判断中已经返回了null
        if (left == null) return right;// 左子树既没有P也没有Q,说明在右子树中才能找到
        else if (right == null) return left;// 右子树既没有P也没有Q,说明在左子树中才能找到
        else return root;// 右子树找到一个，左子树找到一个，说明最近的公共节点就是root
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     */
    private boolean flag;
    private TreeNode p, q, res;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        if (findQ(p)) return p;
        if (findP(q)) return q;
        findPQ(root);
        return res;
    }

    private boolean[] findPQ(TreeNode node) {
        if (node == null || flag) return new boolean[]{false, false};
        if (node == p) return new boolean[]{true, false};
        if (node == q) return new boolean[]{false, true};
        boolean[] left = findPQ(node.left);
        boolean[] right = findPQ(node.right);
        boolean findP = left[0] || right[0];
        boolean findQ = left[1] || right[1];
        if (findQ && findP && !flag) {
            flag = true;
            res = node;
        }
        return new boolean[]{findP, findQ};
    }

    private boolean findP(TreeNode node) {
        if (node == null) return false;
        if (node == p) return true;
        return findP(node.left) ||
                findP(node.right);
    }

    private boolean findQ(TreeNode node) {
        if (node == null) return false;
        if (node == q) return true;
        return findQ(node.left) ||
                findQ(node.right);
    }
}
