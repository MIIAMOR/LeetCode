package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/7/6 20:11
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null) return;
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
