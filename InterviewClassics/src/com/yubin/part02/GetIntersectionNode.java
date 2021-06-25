package com.yubin.part02;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/6/25 10:57
 * easy
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode node = headB;
            while (node != null) {
                if (nodeA.equals(node)) return node;
                node = node.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }

    /**
     * 大佬解法
     * 使用两个指针：
     * 一个A走完了走B，另一个B走完了走A
     * 如果有相同节点，必然两个指针相遇
     * 如果没有相遇，两个指针都会走向null
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
