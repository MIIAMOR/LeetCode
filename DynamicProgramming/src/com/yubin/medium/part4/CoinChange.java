package com.yubin.medium.part4;

/**
 * @author MIIAMOR
 * @date 2021/6/21
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示的是coins中的数加起来刚好是i所需要的最小coin数量
        // 如果无法使得coin的值加起来为i，那么把dp[i]设置为一个较大的数，这里默认为amount+2
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 这里初始默认前置状态为amount + 2
            int pre = amount + 2;
            for (int coin : coins) {
                // 要保证最后的结果加起来刚好是amount
                // 递推方程，如果选择了coin作为被加数，那么所需的coin数量就是dp[i-coin]+1
                // 如果无法使数加起来等于i-coin，那么dp[i - coin]的值为amount+2
                // 这里的前置状态也是设置的一个大数
                // 只有当i-coin可以被组合时，i处的dp值才会有效
                if (i - coin >= 0) pre = Math.min(pre, dp[i - coin]);
            }
            dp[i] = pre + 1;
        }
        return (dp[amount] >= amount + 2) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(cc.coinChange(new int[]{2}, 3));
    }
}
