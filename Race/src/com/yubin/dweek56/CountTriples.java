package com.yubin.dweek56;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:11
 */
public class CountTriples {
    public int countTriples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++)
                    if (i * i + j * j == k * k) res++;
        return res;
    }
}
