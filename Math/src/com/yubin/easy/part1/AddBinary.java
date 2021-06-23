package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/23 9:56
 */
public class AddBinary {
    /**
     * 传统的加法模拟
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] charsA = a.toCharArray(), charsB = b.toCharArray();
        int i = charsA.length - 1, j = charsB.length - 1;
        char[] nums = new char[3], next = new char[2];
        nums[2] = '0';
        while (i >= 0 || j >= 0) {
            if (i < 0) nums[0] = '0';
            else nums[0] = charsA[i];
            if (j < 0) nums[1] = '0';
            else nums[1] = charsB[j];
            i--;
            j--;
            next = addChar(nums);
            sb.append(next[1]);
            nums[2] = next[0];
        }
        if (next[0] != '0') sb.append(next[0]);
        sb.reverse();
        return sb.toString();
    }

    private char[] addChar(char[] nums) {
        int count = 0;
        if (nums[0] == '1') count++;
        if (nums[1] == '1') count++;
        if (nums[2] == '1') count++;
        return switch (count) {
            case 1 -> new char[]{'0', '1'};
            case 2 -> new char[]{'1', '0'};
            case 3 -> new char[]{'1', '1'};
            default -> new char[]{'0', '0'};
        };
    }

    public static void main(String[] args) {
        new AddBinary().addBinary("1010",
                "1011");
    }
}
