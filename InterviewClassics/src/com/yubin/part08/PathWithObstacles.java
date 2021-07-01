package com.yubin.part08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/29 22:03
 */
public class PathWithObstacles {
    // 记录矩阵的宽高
    private int m, n;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
//        return pathWithObstacles1(obstacleGrid);
        return pathWithObstacles2(obstacleGrid);
    }

    /**
     * 动态规划后逆序求解
     */
    public List<List<Integer>> pathWithObstacles1(int[][] obstacleGrid) {
        res = new ArrayList<>();
        if (obstacleGrid == null) return res;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return res;
        int bound = m + n + 10;
        int[][] dp = new int[m][n];// 可以到达的位置都是0.不能到达的位置是1
        for (int i = 1; i < m; i++) {
            if (dp[i - 1][0] == bound) dp[i][0] = bound;
            else if (obstacleGrid[i][0] == 1) dp[i][0] = bound;
            else dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[0][i - 1] == bound) dp[0][i] = bound;
            else if (obstacleGrid[0][i] == 1) dp[0][i] = bound;
            else dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = bound;
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        if (dp[m - 1][n - 1] >= bound) return res;
        int i = m - 1, j = n - 1;
        while (i != 0 || j != 0) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(j);
            res.add(0, l);
            if (j == 0 || (i > 0 && dp[i - 1][j] == dp[i][j] - 1)) {
                i--;
                continue;
            }
            if (i == 0 || dp[i][j - 1] == dp[i][j] - 1) j--;
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
        res.add(0, l);
        return res;
    }

    // dfs搜索
    private ArrayList<List<Integer>> res;
    private boolean find;
    private boolean[][] visited;

    private void dfs(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == 1) return;
        if (i == m - 1 && j == n - 1) find = true;
        List<Integer> l = new ArrayList<>();
        l.add(i);
        l.add(j);
        res.add(l);
        visited[i][j] = true;
        if (i + 1 < m && !visited[i + 1][j]) dfs(obstacleGrid, i + 1, j);
        if (find) return;
        if (j + 1 < n && !visited[i][j + 1]) dfs(obstacleGrid, i, j + 1);
        if (find) return;
        res.remove(res.size() - 1);
    }

    /**
     * 直接dfs
     */
    public List<List<Integer>> pathWithObstacles2(int[][] obstacleGrid) {
        res = new ArrayList<>();
        if (obstacleGrid == null) return res;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return res;
        find = false;
        visited = new boolean[m][n];
        dfs(obstacleGrid, 0, 0);
        return res;
    }
}
