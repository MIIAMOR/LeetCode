package com.yubin.part02;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/6/25 10:10
 * medium
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0, currSum;
        ListNode sum = new ListNode(0), res = sum;
        while (l1 != null || l2 != null) {
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            currSum = next + num1 + num2;
            sum.next = new ListNode(currSum % 10);
            sum = sum.next;
            next = currSum / 10;
        }
        if (next != 0) sum.next = new ListNode(next);
        return res.next;
    }
}
