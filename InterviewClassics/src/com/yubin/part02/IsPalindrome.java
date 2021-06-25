package com.yubin.part02;

import com.yubin.basic.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/25 10:20
 * easy
 */
public class IsPalindrome {
    /**
     * List记录数据
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1)))
                return false;
        }
        return true;
    }

    /**
     * dfs求解
     */
    private ListNode head = null;

    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        this.head = head;
        return dfs(head);
    }

    private boolean dfs(ListNode n) {
        if (n.next != null && !dfs(n.next))
            return false;
        if (head.val != n.val)
            return false;
        head = head.next;
        return true;
    }
}
