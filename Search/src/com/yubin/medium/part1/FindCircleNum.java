package com.yubin.medium.part1;

/**
 * DFS
 */
public class FindCircleNum {
    private int num;//省份数
    boolean[] mark;

    public int findCircleNum(int[][] isConnected) {
        num = isConnected.length;
        mark = new boolean[num];
        int res = 0;
        for (int i = 0; i < num; i++) {
            if (dfs(isConnected, i) != 0) res++;
        }
        return res;
    }

    /**
     * 为i省份搜索可以连通的城市
     */
    private int dfs(int[][] isConnected, int i) {
        if (mark[i]) return 0;
        mark[i] = true;
        int res = 1;
        for (int j = 0; j < num; j++) {
            if (isConnected[i][j] == 1) res += dfs(isConnected, j);
        }
        return res;
    }
}
