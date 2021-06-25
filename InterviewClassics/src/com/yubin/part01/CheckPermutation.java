package com.yubin.part01;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/6/23 19:52
 * easy
 */
public class CheckPermutation {
    /**
     * 假设使用到的字符数是26个小写字符
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] countS1 = new int[26], countS2 = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(countS1, countS2);
    }
}
