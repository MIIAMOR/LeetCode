package com.learn.part1;

public class MaxProfit {
    /**
     * 分析：<br>
     * <p>
     * 解法1：暴力遍历数组，记录最大的利益 timeoutError
     * </p>
     *
     * @param prices 股票的价格
     * @return 最大收益
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (prices[j] < prices[i] && res < prices[i] - prices[j]) res = prices[i] - prices[j];
            }
        }
        return res;
    }

    /**
     * 分析：<br>
     * <p>
     * 解法2：图像分析法+动态规划算法<br>
     * 把每个值绘制在折线图中，就可以非常直观看到每个数值的大小关系了<br>
     * 整个过程就是找出极差，右边的数必须大于左边的数<br>
     * 用数组dp表示动态规划的状态数组，则dp[i]表示到第i天时的最大利润。<br>
     * 用变量cur_min_buy维护截止到前一天股票的最低买入价格<br>
     * 则不难看出状态转移方程为dp[i]=max(dp[i-1], prices[i]-cur_min_buy).<br>
     *     在动态记录这个result即可
     * </p>
     *
     * @param prices 股票的价格
     * @return 最大收益
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        // res用来记录当前已经知道的最大利益，currMin用来记录已知的最小股票市价
        int res = 0, currMin = prices[0];
        for (int price : prices) {
            currMin = Math.min(currMin, price);
            res = Math.max(res, price - currMin);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(mp.maxProfit1(prices));
        System.out.println(mp.maxProfit2(prices));
    }
}
