package com.yubin.medium.part4;

import com.yubin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {
    /**
     * 从叶子节点向根节点遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
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
            res.addFirst(nums);
        }
    }
}
