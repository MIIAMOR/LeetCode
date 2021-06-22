package com.yubin.medium.part4;

/**
 * @author MIIAMOR
 * @date 2021/6/21
 */
public class MinSteps {
    /**
     * 质数分解方式，详情见官方解答
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        int res = 0, d = 2;
        while (n > 1) {
            while ((n % d) == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }

    private int res;

    public int minSteps1(int n) {
        if (n == 1) return 0;
        res = Integer.MAX_VALUE;
        dfs(1, 1, 1, n);// 默认第一步是copy操作
        return res;
    }

    /**
     * @param copyNum 当前剪切板上的A的数量
     * @param sum     当前文本中A的数量
     * @param n       最终需要达到的A的数量
     */
    private void dfs(int copyNum, int sum, int count, int n) {
        if (sum > n) return;
        if (sum == n) res = Math.min(res, count);

        // 每次都有两种选择方式
        // 1. 直接粘贴当前剪切板 步数+1
        dfs(copyNum, sum + copyNum, count + 1, n);
        // 2. 复制当前文本再粘贴
        dfs(sum, sum * 2, count + 2, n);
    }

    public int minSteps2(int n) {
        if (n == 1) return 0;
        int h = (int) Math.sqrt(n);
        // 表示达到i个A所需的最小次数
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;// 默认的初始值为copy1次，paste一个i-1次
            // 这里的边界条件使用h而非n/2，可以减少空循环的次数
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    // 在此条件下，说明i个A可以有j个A变换得到
                    // 这个变换的次数就是dp[i/j]
                    // dp[j]->dp[i]等价于dp[j/j]->dp[i/j]等价于dp[1]->dp[i/j]
                    // 对于每个dp[i]，最后进行的都是paste操作而不是copy，dp[1]相当于剪切板为空，也没有进行copy操作
                    // 因此状态转移方程是可行的
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MinSteps ms = new MinSteps();
        System.out.println(ms.minSteps(4));
        System.out.println(ms.minSteps1(4));
        System.out.println(ms.minSteps2(4));
    }
}
