package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/23 9:17
 */
public class RomanToInt {
    public int romanToInt(String s) {
        char[] nums = s.toCharArray();
        int res = 0, pre = 0, num;
        for (char c : nums) {
            num = getRomanNum(c);
            if (num > pre)
                res += (num - 2 * pre);
            else res += num;
            pre = num;
        }
        return res;
    }

    private int getRomanNum(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
