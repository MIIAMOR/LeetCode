package com.yubin.easy.part3;

import com.yubin.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private List<String> res = null;
    private StringBuilder sb = null;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        dfs(root);
        return res;
    }

    /**
     * 记住：node.val的值转换的字符串可能是多位
     * 对StringBuilder sb进行状态恢复的时候需要删除指定的位数
     *
     * @param node 待查找的树节点
     */
    private void dfs(TreeNode node) {
        String num = String.valueOf(node.val);
        int len = num.length();
        if (node.left == null && node.right == null) {
            sb.append(num);
            res.add(sb.toString());
            sb.delete(sb.length() - len, sb.length());
            return;
        }
        sb.append(num).append("->");
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
        sb.delete(sb.length() - 2 - len, sb.length());
    }
}
