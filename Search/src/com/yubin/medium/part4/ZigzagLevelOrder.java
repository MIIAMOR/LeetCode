package com.yubin.medium.part4;

import com.yubin.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) return res;
        list.addLast(root);
        boolean flag = true;
        while (true) {
            int size = list.size();
            if (size == 0) return res;
            LinkedList<TreeNode> childNodes = new LinkedList<>();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = null;
                if (flag) node = list.removeFirst();
                else node = list.removeLast();
                nums.add(node.val);
                if (flag) {
                    if (node.left != null) childNodes.addLast(node.left);
                    if (node.right != null) childNodes.addLast(node.right);
                } else {
                    if (node.right != null) childNodes.addFirst(node.right);
                    if (node.left != null) childNodes.addFirst(node.left);
                }
            }
            res.add(nums);
            list = childNodes;
            flag = !flag;
        }
    }
}
