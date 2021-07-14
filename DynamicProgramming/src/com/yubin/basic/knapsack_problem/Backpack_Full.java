package com.yubin.basic.knapsack_problem;

/**
 * @author MIIAMOR
 * @date 2021/7/2 20:43
 */
public class Backpack_Full {
    /**
     * @param goods goods[i][0]表示第i个物品的价值，goods[i][1]表示第i个物品的体积
     * @param V     背包的容量
     * @return 最大价值
     */
    public int backpack_Full(int[][] goods, int V) {
        return solution_1(goods, V);
    }

    /**
     * 完全背包问题
     * <p>
     * 二维解法：定义二维数组dp，dp[i][j]表示的是只在前i个物品中取出，且背包容量为j的情况下最大的价值
     * <p>
     * 状态转移方程：
     * dp[j] = Math.max(dp[j], dp[j - goods[i - 1][1] + goods[i - 1][0]]);
     */
    private int solution_1(int[][] goods, int V) {
        int N = goods.length;
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = goods[i - 1][1]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - goods[i - 1][1]] + goods[i - 1][0]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        Backpack_Full backpack_full = new Backpack_Full();
        System.out.println(backpack_full.backpack_Full(new int[][]
                        {{2, 1}, {4, 2}, {4, 3}, {5, 4}}
                , 5));
    }
}
