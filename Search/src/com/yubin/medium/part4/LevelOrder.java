package com.yubin.medium.part4;

import com.yubin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) return res;
        list.addLast(root);
        while (true) {
            int size = list.size();
            if (size == 0) return res;
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                nums.add(node.val);
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            res.add(nums);
        }
    }
}
