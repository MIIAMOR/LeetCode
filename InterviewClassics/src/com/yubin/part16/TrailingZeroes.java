package com.yubin.part16;

/**
 * @author MIIAMOR
 * @date 2021/7/13 19:12
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        return countFive(n);
    }

    private int countFive(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
