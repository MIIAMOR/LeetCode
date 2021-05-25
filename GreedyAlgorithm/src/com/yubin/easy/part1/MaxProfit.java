package com.yubin.easy.part1;

public class MaxProfit {
    /**
     * 思路1：动态规划
     * 对于每一天，都只有买或者麦两种情况
     * 定义一个二维数组
     * 记录在那一天卖或者买所能得到的利益
     * 同时记录在那一天之前最后进行买操作或者卖操作时所保存的最大利益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] profit = new int[prices.length][2];//0-buy 1-sell
        profit[0][0] = -1 * prices[0];
        profit[0][1] = 0;
        int currBuy = profit[0][0];
        int currSell = profit[0][1];
        for (int i = 1; i < prices.length; i++) {
            //对于买,下一个值是当前卖-下一个股票价值|对于卖同理
            profit[i][0] = currSell - prices[i];
            profit[i][1] = currBuy + prices[i];
            //重置当前已知卖或者买能有的最大存款
            currBuy = Math.max(currBuy, profit[i][0]);
            currSell = Math.max(currSell, profit[i][1]);
        }
        return currSell;
    }

    /**
     * 空间优化
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int currSell;
        int currBuy;
        int preBuy = -1 * prices[0];
        int preSell = 0;
        for (int i = 1; i < prices.length; i++) {
            //对于买,下一个值是当前卖-下一个股票价值|对于卖同理
            currBuy = preSell - prices[i];
            currSell = preBuy + prices[i];
            //重置当前已知卖或者买能有的最大存款
            preBuy = Math.max(preBuy, currBuy);
            preSell = Math.max(preSell, currSell);
        }
        return preSell;
    }

    /**
     * 贪心思想
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += (prices[i] - prices[i - 1]);
        }
        return res;
    }

    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit1(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static void main(String[] args) {
        new MaxProfit().test();
    }
}
