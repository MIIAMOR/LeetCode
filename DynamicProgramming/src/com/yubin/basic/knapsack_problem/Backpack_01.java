package com.yubin.basic.knapsack_problem;

/**
 * @author MIIAMOR
 * @date 2021/7/2 20:03
 */
public class Backpack_01 {
    /**
     * @param goods goods[i][0]表示第i个物品的价值，goods[i][1]表示第i个物品的体积
     * @param V     背包的容量
     * @return 最大价值
     */
    public int backpack_01(int[][] goods, int V) {
//        return solution_1(goods, V);
        return solution_2(goods, V);
    }

    /**
     * 0-1背包问题
     * <p>
     * 二维解法：定义二维数组dp，dp[i][j]表示的是只在前i个物品中取出，且背包容量为j的情况下最大的价值
     * <p>
     * 状态转移方程：
     * if (j >= goods[i - 1][1])
     * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][1]] + goods[i - 1][0]);
     * else
     * dp[i][j] = dp[i - 1][j];
     */
    private int solution_1(int[][] goods, int V) {
        int N = goods.length;
        int[][] dp = new int[N + 1][V + 1];// 不取物品的情况下（i == 0），所得的价值自然也是0
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= goods[i - 1][1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][1]] + goods[i - 1][0]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][V];
    }

    /**
     * 从上面的状态转移方程中可以看出：
     * 每个状态都只会与 i - 1 的状态有关
     */
    private int solution_2(int[][] goods, int V) {
        int N = goods.length;
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            // 这里需要的使用上一层的状态，因此需要从后向前遍历，保证状态迭代的顺序
            for (int j = V; j >= goods[i - 1][1]; j--) {
                dp[j] = Math.max(dp[j - goods[i - 1][1]] + goods[i - 1][0], dp[j]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        Backpack_01 backpack_01 = new Backpack_01();
        System.out.println(backpack_01.backpack_01(new int[][]
                        {{2, 1}, {4, 2}, {4, 3}, {5, 4}}
                , 5));
        System.out.println(backpack_01.backpack_01(new int[][]
                        {{2, 1}, {4, 2}, {4, 4}, {5, 4}}
                , 5));
    }
}
