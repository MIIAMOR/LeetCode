package com.yubin.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
    /**
     * 使用哈希映射外加单调栈<br>
     * 虽然解法上使用了栈，但是不一定非得使用栈数据结构，只要可以发挥出栈的特性就好<br>
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        //建立一个数组记录每一个字母出现的频率（O(n)）
        int[] count = new int[26];
        boolean[] in = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[s.charAt(i) - 'a']--;
            if (in[index]) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > s.charAt(i) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                in[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(s.charAt(i));
            in[index] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("bcabc"));
        System.out.println(rdl.removeDuplicateLetters("cbacdcbc"));
        System.out.println(rdl.removeDuplicateLetters("edebbed"));
        System.out.println(rdl.removeDuplicateLetters("cbacdcbc"));
    }
}
