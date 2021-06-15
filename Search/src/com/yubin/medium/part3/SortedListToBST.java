package com.yubin.medium.part3;

import com.yubin.ListNode;
import com.yubin.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    /**
     * 自顶向下构建二叉树
     */
    private TreeNode dfsUTB(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode tree = new TreeNode(list.get(mid));
        tree.left = dfsUTB(list, left, mid - 1);
        tree.right = dfsUTB(list, mid + 1, right);
        return tree;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }
        return dfsUTB(list, 0, list.size() - 1);
    }


    /**
     * 自底向上构建二叉树
     */
    private ListNode h = null;

    private TreeNode dfsBTU(int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode leftNode = dfsBTU(left, mid - 1);
        TreeNode tree = new TreeNode(h.val);
        h = h.next;
        TreeNode rightNode = dfsBTU(mid + 1, right);
        tree.left = leftNode;
        tree.right = rightNode;
        return tree;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        h = head;
        int size = 0;
        while (h != null) {
            size++;
            h = h.next;
        }
        h = head;
        return dfsBTU(0, size - 1);
    }
}