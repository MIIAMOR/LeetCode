package com.yubin.part1;

/**
 * 动态规划题目：斐波那契数列
 */
public class Fibonacci {
    /**
     * 递归算法，重复调用自身。可能栈内存溢出
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    /**
     * 动态规划算法，可以优化，不必开辟数组
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    /**
     * 动态规划改良，减少内存消耗
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int sum = 0, pre = 0, curr = 1;
            for (int i = 1; i < n; i++) {
                sum = curr + pre;
                pre = curr;
                curr = sum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib2(5));
        System.out.println(f.fib1(5));
        System.out.println(f.fib3(5));
    }
}
