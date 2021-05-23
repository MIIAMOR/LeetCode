package com.yubin.easy.part1;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        int gap = 'a' - 'A';
        while (left <= right) {
            if (!isChar(s.charAt(left)) && !isNum(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isChar(s.charAt(right)) && !isNum(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (isChar(s.charAt(left)) && isChar(s.charAt(right)) && Math.abs(s.charAt(left) - s.charAt(right)) == gap) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }

    private boolean isChar(char c) {
        return (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A');
    }

    private boolean isNum(char c) {
        return (c <= '9' && c >= '0');
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man a plan a canal Panama"));
        System.out.println(new IsPalindrome().isPalindrome("race a car"));
    }
}
