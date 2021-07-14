package com.yubin.easy.part3;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/7/7 18:42
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            second = second.next == null ? null : second.next;
            return second;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
