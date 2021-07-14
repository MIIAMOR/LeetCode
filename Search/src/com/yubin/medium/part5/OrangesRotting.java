package com.yubin.medium.part5;

import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/7/11 14:39
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        LinkedList<int[]> q = new LinkedList<>();
        int count = 0, time = -1;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) count++;
            }
        }
        if (count == 0) return 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] pos = q.removeFirst();
                int x = pos[0], y = pos[1];
                int u = x - 1, d = x + 1, l = y - 1, r = y + 1;
                if (u >= 0 && grid[u][y] == 1) {
                    q.addLast(new int[]{u, y});
                    grid[u][y] = 2;
                    count--;
                }
                if (d < m && grid[d][y] == 1) {
                    q.addLast(new int[]{d, y});
                    grid[d][y] = 2;
                    count--;
                }
                if (l >= 0 && grid[x][l] == 1) {
                    q.addLast(new int[]{x, l});
                    grid[x][l] = 2;
                    count--;
                }
                if (r < n && grid[x][r] == 1) {
                    q.addLast(new int[]{x, r});
                    grid[x][r] = 2;
                    count--;
                }
            }
        }
        return count == 0 ? time : -1;
    }

    public static void main(String[] args) {
        new OrangesRotting().orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        });
    }
}
