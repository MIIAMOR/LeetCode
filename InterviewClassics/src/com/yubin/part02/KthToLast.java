package com.yubin.part02;

import com.yubin.basic.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/24 16:07
 * easy
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode n = head;
        List<Integer> list = new ArrayList<>();
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }
        return list.get(list.size() - k);
    }

    /**
     * 双指针解法：第一个指针走k步，两个指针同时走，当一个指针走到了null
     * 第二个指针就走到了倒数第k个位置
     */
    public int kthToLast1(ListNode head, int k) {
        ListNode n = head;
        ListNode res = head;
        for (int i = 0; i < k; i++) {
            n = n.next;
        }
        while (n != null) {
            res = res.next;
            n = n.next;
        }
        return res.val;
    }


}
