package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 13:39
 */
public class InsertBits {
    public int insertBits(int N, int M, int i, int j) {
        // N的i-j位置0
        for (int x = i; x <= j; x++) {
            int base = (1 << x);
            if ((N & base) == base) N -= base;
        }
        // 加上M
        return N + (M << i);
    }
}
