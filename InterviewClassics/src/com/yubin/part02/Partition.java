package com.yubin.part02;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/6/25 9:25
 * medium
 */
public class Partition {
    /**
     * 有点没看懂题目,不是说x的节点必须在右边，不能在交界处
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(x), res = left;
        ListNode mid = new ListNode(x), midRes = mid;
        ListNode right = new ListNode(x), rightRes = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else if (head.val > x) {
                mid.next = head;
                mid = mid.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        mid.next = rightRes.next;
        left.next = midRes.next;
        return res.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode left = new ListNode(x), leftRes = left;
        ListNode right = new ListNode(x), rightRes = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightRes.next;
        return leftRes.next;
    }
}
