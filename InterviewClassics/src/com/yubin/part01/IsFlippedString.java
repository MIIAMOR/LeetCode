package com.yubin.part01;

/**
 * @author MIIAMOR
 * @date 2021/6/24 10:52
 * easy
 */
public class IsFlippedString {
    public boolean isFlippedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.substring(0, i).equals(s2.substring(len - i))
                    && s1.substring(i).equals(s2.substring(0, len - i)))
                return true;
        }
        return len == 0;
    }

    /**
     * 大佬的解法
     */
    public boolean isFlippedString1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s = s2 + s2;
        return s.contains(s1);
    }

    public static void main(String[] args) {
        new IsFlippedString().isFlippedString("WaterBottle", "erBottleWat");
    }
}
