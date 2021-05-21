package com.yubin.part1;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int num = left * left + right * right;
            if (num > c) right--;
            else if (num < c) left++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum().judgeSquareSum(5));
    }
}
