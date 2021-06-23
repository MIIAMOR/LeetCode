package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/6/23 16:05
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
