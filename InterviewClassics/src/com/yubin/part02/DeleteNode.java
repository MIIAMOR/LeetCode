package com.yubin.part02;

import com.yubin.basic.ListNode;

/**
 * @author MIIAMOR
 * @date 2021/6/25 9:15
 * easy
 */
public class DeleteNode {
    /**
     * 删除链表中间节点
     *
     * @param node
     */
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode(ListNode node) {
        ListNode pre = node;
        node.val = node.next.val;
        node = node.next;
        while (node.next != null) {
            node.val = node.next.val;
            node = node.next;
            pre = pre.next;
        }
        pre.next = null;
    }
}
