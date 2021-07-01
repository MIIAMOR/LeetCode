package com.yubin.part04;

import com.yubin.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/27 22:05
 */
public class BSTSequencesClass {
    /**
     * https://leetcode-cn.com/problems/bst-sequences-lcci/solution/pei-tu-hui-su-mo-ban-xiang-xi-zhu-shi-by-dong-men/
     * --------------------------------------------------------------------------------------------------------
     */
    private LinkedList<Integer> list;// 存放可能的路径
    private LinkedList<TreeNode> rest;// 存放在当前已知部分路径的情况下还可以选择的节点
    private List<List<Integer>> res;// 最终结果

    public List<List<Integer>> BSTSequences(TreeNode root) {
        list = new LinkedList<>();
        res = new ArrayList<>();
        rest = new LinkedList<>();
        if (root == null) {
            res.add(new LinkedList<>());
            return res;
        }
        rest.addLast(root);
        backtracking();
        return res;
    }

    private void backtracking() {
        int size = rest.size();
        if (size == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < size; i++) {
            TreeNode node = rest.removeFirst();
            list.addLast(node.val);
            int count = 0;
            if (node.left != null) {
                rest.addLast(node.left);
                count++;
            }
            if (node.right != null) {
                rest.addLast(node.right);
                count++;
            }
            backtracking();
            for (int j = 0; j < count; j++) {
                rest.removeLast();
            }
            list.removeLast();
            rest.addLast(node);
        }
    }
}
