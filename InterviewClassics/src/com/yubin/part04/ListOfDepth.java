package com.yubin.part04;

import com.yubin.basic.ListNode;
import com.yubin.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/6/26 21:59
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        LinkedList<TreeNode> level = new LinkedList<>();
        ArrayList<ListNode> res = new ArrayList<>();
        level.addLast(tree);
        while (true) {
            int size = level.size();
            if (size == 0) break;
            ListNode head = new ListNode(0), listNode = head;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = level.removeFirst();
                listNode.next = new ListNode(treeNode.val);
                listNode = listNode.next;
                if (treeNode.left != null) level.addLast(treeNode.left);
                if (treeNode.right != null) level.addLast(treeNode.right);
            }
            res.add(head.next);
        }
        ListNode[] ans = new ListNode[res.size()];
        int index = 0;
        for (ListNode listNode : res) {
            ans[index++] = listNode;
        }
        return ans;
    }
}
