package com.yubin.easy.part1;

import com.yubin.basic.TreeNode;

public class IsSymmetric {
    /**
     * 假设有两棵一模一样的数，分别前序遍历和后序遍历
     */
    public boolean isSymmetric1(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        if (!dfs(root1.left, root2.right)) return false;
        return dfs(root1.right, root2.left);
    }

    /**
     * 记录遍历得到的数
     */
    private StringBuilder sbPre = new StringBuilder();
    private StringBuilder sbPost = new StringBuilder();

    public boolean isSymmetric(TreeNode root) {
        dfs(root, 0);
        dfs(root, 1);
        String pre = sbPre.toString();
        String post = sbPost.toString();
        return pre.equals(post);
    }

    /**
     * 对称树前序和后序遍历结果一样
     */
    private void dfs(TreeNode root, int flag) {
        if (root == null) {
            if (flag == 0) sbPre.append('n');
            else sbPost.append('n');
            return;
        }
        if (flag == 0) {
            sbPre.append(root.val);
            dfs(root.left, flag);
            dfs(root.right, flag);
        } else {
            sbPost.append(root.val);
            dfs(root.right, flag);
            dfs(root.left, flag);
        }
    }

    public void test() {
        TreeNode right2 = new TreeNode(3);
        TreeNode left1 = new TreeNode(2, null, right2);

        TreeNode right22 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2, null, right22);

        TreeNode root = new TreeNode(1, left1, right1);
        System.out.println(isSymmetric1(root));
    }

    public static void main(String[] args) {
        new IsSymmetric().test();
    }
}
