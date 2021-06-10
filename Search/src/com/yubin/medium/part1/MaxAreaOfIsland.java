package com.yubin.medium.part1;

/**
 * DFS
 */
public class MaxAreaOfIsland {
    private int col;
    private int row;

    /**
     * dfs深度优先搜索
     */
    public int maxAreaOfIsland(int[][] grid) {
        col = grid.length;
        row = grid[0].length;
        boolean[][] mark = new boolean[col][row];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(dfs(grid, mark, i, j), res);
            }
        }
        return res;
    }

    /**
     * 深度优先搜索，求岛屿可以连接的最大值
     */
    private int dfs(int[][] grid, boolean[][] mark, int i, int j) {
        if (grid[i][j] == 0 || mark[i][j]) return 0;
        int res = 1;
        mark[i][j] = true;
        if (i - 1 >= 0) res += dfs(grid, mark, i - 1, j);
        if (j - 1 >= 0) res += dfs(grid, mark, i, j - 1);
        if (i + 1 < col) res += dfs(grid, mark, i + 1, j);
        if (j + 1 < row) res += dfs(grid, mark, i, j + 1);
        return res;
    }
}
