package com.yubin.part02;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/6/25 17:00
 * medium
 */
public class DetectCycle {
    /**
     * 环路检测使用双指针解法解答
     * 环入口地址求解方式：数学方式
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) return null;
            if (fast == slow) {
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }
}
