package com.yubin.medium.part1;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     */
    /**
     * 1.判断链中是否存在环
     * 2.由于快指针已经比慢指针走了2倍距离
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else return null;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 哈希集合解法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode ptr = head;
        while (ptr != null) {
            if (visited.contains(ptr)) return ptr;
            visited.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void test() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(detectCycle(head).val);
    }

    public void test1() {
        ListNode head1 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        head1.next = n11;
        n11.next = head1;
        System.out.println(detectCycle(head1).val);
    }

    public void test2() {
        ListNode head2 = new ListNode(1);
        System.out.println(detectCycle(head2));
        System.out.println(detectCycle(null));
    }

    public void test3() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        System.out.println(detectCycle(head));
    }


    public static void main(String[] args) {
        DetectCycle dc = new DetectCycle();
        dc.test();
        dc.test1();
        dc.test2();
        dc.test3();
    }
}
