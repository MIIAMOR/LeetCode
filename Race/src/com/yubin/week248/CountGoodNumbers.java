package com.yubin.week248;

/**
 * @author MIIAMOR
 * @date 2021/7/4 21:24
 */
public class CountGoodNumbers {
    private final long mod = (long) (1e9 + 7);

    /**
     * 对于一个数，奇数位置有四种选择2，3，5，7，偶数位置有五种选择0，2，4，6，8
     */
    public int countGoodNumbers(long n) {
        // 对于n而言，他的偶数位置数量为(n + 1) / 2，奇数位数量为n - even
        long even = (n + 1) / 2, odd = n / 2;
        long res = quickPow(5, even) * quickPow(4, odd) % mod;
        return (int) res;
    }

    /**
     * 利用二进制计算幂数
     */
    private long quickPow(long a, long b) {
        long res = 1;
        while ((b) != 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            b = b >> 1;
            a = a * a % mod;
        }
        return res;
    }
}
