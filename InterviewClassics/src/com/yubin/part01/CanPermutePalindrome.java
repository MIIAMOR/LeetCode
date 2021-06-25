package com.yubin.part01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/6/23 20:36
 * easy
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int odd = 0;
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (int i : count) {
            if (i % 2 == 1) odd++;
        }
        return odd <= 1;
    }

    public boolean canPermutePalindrome1(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.size() <= 1;
    }
}
