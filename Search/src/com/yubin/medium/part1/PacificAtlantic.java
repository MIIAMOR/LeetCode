package com.yubin.medium.part1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlantic {
    /**
     * 确定边界
     */
    private int row;
    private int col;

    private boolean pOk[][];
    private boolean aOk[][];

    /**
     * dfs逆向遍历从边界出发，找到可以到达的点
     */
    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        pOk = new boolean[row][col];
        aOk = new boolean[row][col];
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, pOk);
            dfs(heights, i, col - 1, aOk);
        }
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, pOk);
            dfs(heights, row - 1, i, aOk);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pOk[i][j] && aOk[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    /**
     * 确定边界点可以达到的点
     */
    private void dfs(int[][] heights, int i, int j, boolean[][] ok) {
        ok[i][j] = true;
        int height = heights[i][j];
        if (inAra(i - 1, j) && heights[i - 1][j] >= height && !ok[i - 1][j])
            dfs(heights, i - 1, j, ok);
        if (inAra(i, j - 1) && heights[i][j - 1] >= height && !ok[i][j - 1])
            dfs(heights, i, j - 1, ok);
        if (inAra(i + 1, j) && heights[i + 1][j] >= height && !ok[i + 1][j])
            dfs(heights, i + 1, j, ok);
        if (inAra(i, j + 1) && heights[i][j + 1] >= height && !ok[i][j + 1])
            dfs(heights, i, j + 1, ok);
    }

    private boolean inAra(int i, int j) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }


    /**
     * 遍历每个点，确定其可以到达的海
     */
    private boolean[][] mark;
    private boolean[][] ok;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        ok = new boolean[row][col];
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mark = new boolean[row][col];
                if (dfs1(heights, i, j)) {
                    mark = new boolean[row][col];
                    if (dfs2(heights, i, j)) {
                        ok[i][j] = true;
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res;
    }

    /**
     * 确定可以达到太平洋
     */
    private boolean dfs1(int[][] heights, int i, int j) {
        mark[i][j] = true;
        if (i <= 0 || j <= 0)
            return true;
        if (heights[i - 1][j] <= heights[i][j] && !mark[i - 1][j]) {
            if (ok[i - 1][j]) return true;
            if (dfs1(heights, i - 1, j)) return true;
        }
        if (heights[i][j - 1] <= heights[i][j] && !mark[i][j - 1]) {
            if (ok[i][j - 1]) return true;
            if (dfs1(heights, i, j - 1)) return true;
        }
        if (i + 1 < row && heights[i + 1][j] <= heights[i][j] && !mark[i + 1][j]) {
            if (ok[i + 1][j]) return true;
            if (dfs1(heights, i + 1, j)) return true;
        }
        if (j + 1 < col && heights[i][j + 1] <= heights[i][j] && !mark[i][j + 1]) {
            if (ok[i][j + 1]) return true;
            if (dfs1(heights, i, j + 1)) return true;
        }
        return false;
    }

    /**
     * 确定可以达到大西洋
     */
    private boolean dfs2(int[][] heights, int i, int j) {
        mark[i][j] = true;
        if (i >= row - 1 || j >= col - 1)
            return true;
        if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j] && !mark[i - 1][j]) {
            if (ok[i - 1][j]) return true;
            if (dfs2(heights, i - 1, j)) return true;
        }
        if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j] && !mark[i][j - 1]) {
            if (ok[i][j - 1]) return true;
            if (dfs2(heights, i, j - 1)) return true;
        }
        if (heights[i + 1][j] <= heights[i][j] && !mark[i + 1][j]) {
            if (ok[i + 1][j]) return true;
            if (dfs2(heights, i + 1, j)) return true;
        }
        if (heights[i][j + 1] <= heights[i][j] && !mark[i][j + 1]) {
            if (ok[i][j + 1]) return true;
            if (dfs2(heights, i, j + 1)) return true;
        }
        return false;
    }

    public void test() {
        List<List<Integer>> res = pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        });
        List<List<Integer>> res1 = pacificAtlantic1(new int[][]{
                {4, 4, 1, 7, 4, 18, 5, 5, 1, 6, 6, 10, 17, 19, 13, 3, 19},
                {19, 8, 3, 14, 18, 11, 2, 2, 5, 2, 19, 15, 18, 12, 16, 7, 19},
                {2, 4, 15, 2, 6, 4, 18, 13, 12, 11, 0, 11, 6, 19, 17, 11, 9}
        });
    }

    public static void main(String[] args) {
        new PacificAtlantic().test();
    }
}