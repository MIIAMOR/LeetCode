package com.yubin.easy.part1;

import java.util.Arrays;

public class IsAnagram {
    /**
     * 排序后逐一比较
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < len; i++) {
            if (sc[i] != tc[i]) return false;
        }
        return true;
    }

    /**
     * 哈希集合
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        int[] sNum = new int[26];
        int[] tNum = new int[26];
        for (int i = 0; i < len; i++) {
            sNum[s.charAt(i) - 'a']++;
            tNum[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sNum[i] != tNum[i]) return false;
        }
        return true;
    }

    public void test() {
        System.out.println(isAnagram("as", "sa"));
    }

    public static void main(String[] args) {
        new IsAnagram().test();
    }
}
