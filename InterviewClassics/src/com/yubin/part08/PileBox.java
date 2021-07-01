package com.yubin.part08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author MIIAMOR
 * @date 2021/7/1 19:34
 */
public class PileBox {
    public int pileBox(int[][] box) {
        // 先排序，按宽从小到大
        Arrays.sort(box, Comparator.comparingInt(a -> a[0]));
        int len = box.length;
        int res = 0;// 用于记录最终的结果
        int[] dp = new int[len];// dp[i]表示的是，取第i个箱子作为基的情况下所能达到的最大高度
        for (int i = 0; i < len; i++) {
            dp[i] = box[i][2];// 假设每一种的初始情况都只有一个箱子
            for (int j = 0; j < i; j++) {
                // 对该箱子之前的情况进行遍历，如果这些重叠起来的箱子可以放在新的基的话
                // 则加上当前的箱子的高度
                if (box[j][0] < box[i][0] && box[j][1] < box[i][1] && box[j][2] < box[i][2])// 这里需要严格小于
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}