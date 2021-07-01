package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/6/29 21:38
 */
public class WaysToStep {
    /**
     * 动态规划：
     * 当要达到第n阶梯的时候，可以从n-3走3步，n-2走2步或者n-1走一步三种方式
     * 所以f(n) = f(n-1) + f(n-2) + f(n-3)
     */
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int step1 = 1, step2 = 2, step3 = 4;
        int nextStep = 0;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            nextStep = step1 + step2;
            if (nextStep >= mod) nextStep -= mod;
            nextStep += step3;
            if (nextStep >= mod) nextStep -= mod;
            step1 = step2;
            step2 = step3;
            step3 = nextStep;
        }
        return nextStep;
    }
}
