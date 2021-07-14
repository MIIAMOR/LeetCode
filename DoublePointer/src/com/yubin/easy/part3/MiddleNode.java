package com.yubin.easy.part3;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/7/7 18:37
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
