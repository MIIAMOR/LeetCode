package com.yubin.part01;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/6/23 19:31
 * easy
 */
public class IsUnique {
    /**
     * 哈希集合存储
     */
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    /**
     * 暴力枚举法
     */
    public boolean isUnique1(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) return false;
            }
        }
        return true;
    }

    /**
     * 排序后对比
     */
    public boolean isUnique2(String astr) {
        char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) return false;
        }
        return true;
    }

    /**
     * 数组计数法
     */
    public boolean isUnique3(String astr) {
        int[] count = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (count[c] != 0) return false;
            count[c]++;
        }
        return true;
    }

    /**
     * 假设题目中使用的字符数为26个小写字符
     * 使用位运算算法
     * << 是左移运算符
     */
    public boolean isUnique4(String astr) {
        int count = 0, base = 1, countChar;
        for (char c : astr.toCharArray()) {
            int offset = c - 'a';
            countChar = base << offset;
            if ((count & countChar) > 0) return false;
            count |= countChar;
        }
        return true;
    }
}

