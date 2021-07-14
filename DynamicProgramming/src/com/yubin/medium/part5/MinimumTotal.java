package com.yubin.medium.part5;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/7/14 9:14
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal1(triangle);
//        return minimumTotal2(triangle);
    }

    private int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                if (j == 0) dp[i][j] = dp[i - 1][j] + num;
                else if (i == j) dp[i][j] = dp[i - 1][j - 1] + num;
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + num;
            }
        }
        for (int i : dp[n - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }

    private int res = Integer.MAX_VALUE;
    private int len;
    private int sum;

    private int minimumTotal2(List<List<Integer>> triangle) {
        len = triangle.size();
        sum = triangle.get(0).get(0);
        dfs(triangle, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> triangle, int length, int index) {
        if (length == len - 1) {
            res = Math.min(res, sum);
            return;
        }
        List<Integer> list = triangle.get(length + 1);
        sum += list.get(index);
        dfs(triangle, length + 1, index);
        sum -= triangle.get(length + 1).get(index);
        sum += triangle.get(length + 1).get(index + 1);
        dfs(triangle, length + 1, index + 1);
        sum -= triangle.get(length + 1).get(index + 1);
    }
}
