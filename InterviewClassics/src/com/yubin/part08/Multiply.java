package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/6/30 11:11
 */
public class Multiply {
    public int multiply(int A, int B) {
        // 符号判断
        int sign = -1;
        if ((A > 0 && B > 0) || (A < 0 && B < 0)) sign = 1;
        int small = Math.min(Math.abs(A), Math.abs(B));
        int big = Math.max(Math.abs(A), Math.abs(B));

        int res = multiply1(small, big);
//        int res = multiply2(small, big);

        return sign == -1 ? -res : res;
    }

    /**
     * 直接相加法
     */
    public int multiply1(int A, int B) {
        int res = 0;
        for (int i = 0; i < A; i++) {
            res += B;
        }
        return res;
    }

    /**
     * 递归求解
     */
    public int multiply2(int A, int B) {
        if (A == 0) return 0;
        return B + multiply2(A - 1, B);
    }
}
