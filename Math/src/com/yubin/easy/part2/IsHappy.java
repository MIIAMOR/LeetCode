package com.yubin.easy.part2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/6/23 14:19
 */
public class IsHappy {
    private int getTotal(int n) {
        int sum = 0;
        while (n >= 1) {
            int num = n % 10;
            sum += (num * num);
            n /= 10;
        }
        return sum;
    }

    /**
     * 哈希表存储
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = getTotal(n);
            if (n == 1) return true;
        }
        return false;
    }

    /**
     * 快慢指针环检测
     */
    public boolean isHappy1(int n) {
        int slow = n, fast = n;
        do {
            slow = getTotal(slow);
            fast = getTotal(fast);
            fast = getTotal(fast);
            if (slow == 1 || fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
        System.out.println(new IsHappy().isHappy1(2));
    }
}
