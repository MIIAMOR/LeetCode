package com.yubin.week249;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:07
 */
public class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        char[] c = s.toCharArray();
        boolean[] mark = new boolean[26];
        int n = c.length;
        int res = 0;
        int l = -1, r = n - 1;
        while (r > l) {
            l++;
            if (mark[c[l] - 'a']) continue;
            for (int i = r; i > l + 1; i--) {
                if (c[i] == c[l]) {
                    Set<Character> set = new HashSet<>();
                    for (int j = l + 1; j < i; j++) set.add(c[j]);
                    res += (set.size());
                    mark[c[l] - 'a'] = true;
                    break;
                }
            }
        }
        return res;
    }
}
