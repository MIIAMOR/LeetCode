package com.yubin.part04;

import com.yubin.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/27 14:58
 */
public class InorderSuccessor {
    private List<TreeNode> list;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        list = new ArrayList<>();
        inorder(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == p) {
                if (i < list.size() - 1)
                    return list.get(i + 1);
                else return null;
            }
        }
        return null;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------
     */
    private int flag;
    private TreeNode res;

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        flag = 0;
        inorder(root, p);
        return res;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (flag == -1) return;
        inorder(root.left, p);
        if (flag == 1) {
            res = root;
            flag = -1;
            return;
        } else if (flag == 0 && root == p)
            flag = 1;
        inorder(root.right, p);
    }
}
