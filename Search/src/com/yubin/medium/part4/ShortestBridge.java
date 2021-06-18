package com.yubin.medium.part4;

import java.util.LinkedList;

/**
 * 算法思路：
 * 1. 使用dfs找到两个岛屿
 * 2. 对其中一个岛屿进行bfs扩充，直到碰到第二个岛屿
 */
public class ShortestBridge {
    private int m = 0;
    private int n = 0;

    // 第一个岛屿的边界
    private LinkedList<int[]> boundary = null;

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boundary = new LinkedList<>();
        int flag = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, boundary, i, j);
                    flag++;
                }
                if (flag != 0) break;
            }
            if (flag != 0) break;
        }
        return bfs(grid);
    }

    /**
     * 对边界1进行bfs扩展，遇到
     */
    private int bfs(int[][] grid) {
        int res = 1;
        while (true) {
            int size = boundary.size();
            for (int i = 0; i < size; i++) {
                int[] index = boundary.removeFirst();
                int north = index[0] - 1;
                int south = index[0] + 1;
                int west = index[1] - 1;
                int east = index[1] + 1;
                if (north >= 0) {
                    if (grid[north][index[1]] == 1) return res;
                    if (grid[north][index[1]] == 0) {
                        grid[north][index[1]] = 2;
                        boundary.add(new int[]{north, index[1]});
                    }
                }
                if (south < m) {
                    if (grid[south][index[1]] == 1) return res;
                    if (grid[south][index[1]] == 0) {
                        grid[south][index[1]] = 2;
                        boundary.add(new int[]{south, index[1]});
                    }
                }
                if (west >= 0) {
                    if (grid[index[0]][west] == 1) return res;
                    if (grid[index[0]][west] == 0) {
                        grid[index[0]][west] = 2;
                        boundary.add(new int[]{index[0], west});
                    }
                }
                if (east < n) {
                    if (grid[index[0]][east] == 1) return res;
                    if (grid[index[0]][east] == 0) {
                        grid[index[0]][east] = 2;
                        boundary.add(new int[]{index[0], east});
                    }
                }
            }
            res++;
        }
    }

    private void dfs(int[][] grid, LinkedList<int[]> boundary, int i, int j) {
        if (grid[i][j] == 0) {
            boundary.add(new int[]{i, j});
            grid[i][j] = 2;
            return;
        }
        if (grid[i][j] == 2) return;
        grid[i][j] = 2;
        if (i - 1 >= 0) {
            dfs(grid, boundary, i - 1, j);
        }
        if (j - 1 >= 0) {
            dfs(grid, boundary, i, j - 1);
        }
        if (i + 1 < m) {
            dfs(grid, boundary, i + 1, j);
        }
        if (j + 1 < n) {
            dfs(grid, boundary, i, j + 1);
        }
    }

    public void test() {
        System.out.println(shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        }));
    }

    public static void main(String[] args) {
        new ShortestBridge().test();
    }
}