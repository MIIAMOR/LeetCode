package com.yubin.part1;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        int flag = 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right) || s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (flag == 0) return false;
                if (s.charAt(left + 1) == s.charAt(right) && s.charAt(left) != s.charAt(right - 1)) left++;
                else if (s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) != s.charAt(right)) right--;
                else return false;
                flag--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.validPalindrome("aba"));
        System.out.println(vp.validPalindrome("cbbcc"));
        System.out.println(vp.validPalindrome("lcuppucul"));
    }
}
