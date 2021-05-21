package com.yubin.part1;

public class LengthOfLongestSubstring {
    /**
     * 双指针之滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //数组用于记录对应字母在已经遍历的字符中最后一次出现的位置
        int[] position = new int[128];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
        int left = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //记录该字符上一次出现位置和当前作为基准线的位置的大小
            left = Math.max(left, position[s.charAt(i)]);
            //重新记录这个字符最后一次出现的位置
            position[s.charAt(i)] = i;
            //比较当前已知的最大长度和新的最大长度
            res = Math.max(res, i - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lls = new LengthOfLongestSubstring();
        System.out.println(lls.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lls.lengthOfLongestSubstring(" "));
    }
}
