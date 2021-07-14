package com.yubin.linkedlist.easy;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/7/12 11:02
 */
public class ReverseList {
    private ListNode node = new ListNode(), n = node;

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        reverse(head);
        return node.next;
    }

    private void reverse(ListNode node) {
        if (node == null) return;
        reverse(node.next);
        n.next = new ListNode(node.val);
        n = n.next;
    }
}
