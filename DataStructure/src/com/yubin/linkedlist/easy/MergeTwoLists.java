package com.yubin.linkedlist.easy;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/7/12 10:34
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode();
        ListNode n = node;
        while (true) {
            if (l1 == null) {
                n.next = l2;
                break;
            } else if (l2 == null) {
                n.next = l1;
                break;
            } else if (l1.val < l2.val) {
                n.next = new ListNode(l1.val);
                l1 = l1.next;
                n = n.next;
            } else {
                n.next = new ListNode(l2.val);
                l2 = l2.next;
                n = n.next;
            }
        }
        return node.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode();
        if (l1.val < l2.val) {
            node.val = l1.val;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node.val = l2.val;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }
}
