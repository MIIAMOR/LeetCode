package com.yubin.part08;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/6/30 21:23
 */
public class WaysToChange {
    private final int mod = 1000000007;

    public int waysToChange(int n) {
//        return waysToChange1(n);// 超时
//        return waysToChange2(n);// 超时
//        return waysToChange3(n);
        return waysToChange4(n);
    }

    /**
     * 数学解法:试硬币
     */
    public int waysToChange1(int n) {
        int res = 0;
        for (int coin25 = 0; coin25 <= n / 25; coin25++) {
            int ten = n - coin25 * 25;
            for (int coin10 = 0; coin10 <= ten / 10; coin10++) {
                int five = ten - coin10 * 10;
                for (int coin5 = 0; coin5 <= five / 5; coin5++) {
                    res++;
                    if (res >= mod) res -= mod;
                }
            }
        }
        return res;
    }

    /**
     * 数学解法优化循环
     */
    public int waysToChange2(int n) {
        int res = 0;
        for (int coin25 = 0; coin25 <= n / 25; coin25++) {
            int ten = n - coin25 * 25;
            for (int coin10 = 0; coin10 <= ten / 10; coin10++) {
                int five = ten - coin10 * 10;
                res += (five / 5 + 1);// (five / 5 + 1)这个式子的值每次减小2，构成等差数列
                if (res >= mod) res -= mod;
            }
        }
        return res;
    }

    /**
     * 继续优化
     */
    public int waysToChange3(int n) {
        long res = 0;
        for (int coin25 = 0; coin25 <= n / 25; coin25++) {
            int rest = n - coin25 * 25;
            long coin10 = rest / 10 + 1;// 等差数列的项数
            long coin5B = rest % 10 / 5 + 1;// 等差数列的首项
            long coin5E = rest / 5 + 1;// 等差数列的末尾项
            res = (res + (coin5E + coin5B) / 2 * coin10) % mod;
        }
        return (int) res;
    }

    /**
     * 完全背包问题模型
     * 总共有四个物品，其价值分别是1，5，10，25，且体积都是1
     * 1硬币不会影响方案的总数：
     * 当n不能被5整除的时候，那么就只能使用1来填充剩余数量，那么方案数不会增加
     * 比如n=5的时候方案数为2，n在值为6..9的时候，方案数也为2
     * <p>
     * 因此可以简化方式为加入只有三个硬币5，10，25
     * <p>
     * 在dp求解的时候，遵循背包问题的一贯思维：先对物品进行遍历，再去对容量进行遍历
     */
    public int waysToChange4(int n) {
        int[] coins = new int[]{5, 10, 25};
        int coin5 = n / 5;// 这里因为10和25都是5的倍数，索引只需要考虑硬币面值在5之上的硬币
        int[] dp = new int[coin5 + 1];// 避免越界（解题过程中可以选择多分配点空间，避免越界，dp问题的解题一般从1开始计数、
        Arrays.fill(dp, 1);//假设只有一个1分硬币的情况，那么对于每种n，都会只有一种方式
        for (int coin : coins) {
            for (int i = coin / 5; i <= coin5; i++) {
                dp[i] = (dp[i - coin / 5] + dp[i]) % mod;
            }
        }
        return dp[coin5];
    }


    public static void main(String[] args) {
        System.out.println(new WaysToChange().waysToChange(1000));
    }
}
