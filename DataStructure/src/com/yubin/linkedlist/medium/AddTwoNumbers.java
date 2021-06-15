package com.yubin.linkedlist.medium;

import com.yubin.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode res = new ListNode();
        ListNode list = res;
        int curr = 0, next = 0;
        while (list1 != null || list2 != null) {
            int n1 = 0, n2 = 0;
            if (list1 != null) {
                n1 = list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                n2 = list2.val;
                list2 = list2.next;
            }
            next = (n1 + n2 + curr) / 10;
            curr = (n1 + n2 + curr) % 10;
            list.next = new ListNode(curr);
            list = list.next;
            curr = next;
        }
        if (curr != 0) list.next = new ListNode(curr);
        return res.next;
    }
}