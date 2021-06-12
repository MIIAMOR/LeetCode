package com.yubin.easy.part1;

import com.yubin.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    /**
     * dfs两棵树，判断两树是否相同
     */
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;

        if (!dfs(p.left, q.left))
            return false;
        if (!dfs(p.right, q.right))
            return false;

        return true;
    }
}
