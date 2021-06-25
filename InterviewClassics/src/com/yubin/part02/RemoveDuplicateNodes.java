package com.yubin.part02;

import com.yubin.basic.ListNode;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/6/24 13:09
 * easy
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode n = head;
        List<Integer> list = new ArrayList<>();
        while (n != null) {
            if (!list.contains(n.val))
                list.add(n.val);
            n = n.next;
        }
        n = new ListNode(list.get(0));
        ListNode res = n;
        for (int i = 1; i < list.size(); i++) {
            n.next = new ListNode(list.get(i));
            n = n.next;
        }
        return res;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode n = head;
        ListNode listNode = new ListNode(n.val);
        ListNode res = listNode;
        set.add(n.val);
        while (n != null) {
            if (!set.contains(n.val)) {
                listNode.next = new ListNode(n.val);
                set.add(n.val);
                listNode = listNode.next;
            }
            n = n.next;
        }
        return res;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode n = head;
        set.add(n.val);
        while (n.next != null) {
            if (!set.contains(n.next.val)) {
                set.add(n.next.val);
                n = n.next;
            } else
                n.next = n.next.next;
        }
        return head;
    }

    /**
     * 作弊版哈希表
     */
    public ListNode removeDuplicateNodes3(ListNode head) {
        if (head == null) return null;
        byte[] occurred = new byte[20000];
        ListNode n = head;
        occurred[n.val] = 1;
        while (n.next != null) {
            if (occurred[n.next.val] == 0) {
                occurred[n.next.val] = 1;
                n = n.next;
            } else
                n.next = n.next.next;
        }
        return head;
    }
}
