package com.yubin.dweek56;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:13
 */
public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[entrance[0]][entrance[1]] = 0;
        q.add(new int[]{entrance[0], entrance[1]});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.removeFirst();
                int x = pos[0], y = pos[1];
                if (x == 0 || x == m - 1 || y == 0 || y == n - 1)
                    if (x != entrance[0] || y != entrance[1]) return dist[x][y];
                int u = pos[0] - 1, d = pos[0] + 1, l = pos[1] - 1, r = pos[1] + 1;
                int curr = dist[x][y];
                if (u >= 0 && maze[u][y] == '.' && dist[u][y] == Integer.MAX_VALUE) {
                    dist[u][y] = curr + 1;
                    q.addLast(new int[]{u, y});
                }
                if (d < m && maze[d][y] == '.' && dist[d][y] == Integer.MAX_VALUE) {
                    dist[d][y] = curr + 1;
                    q.addLast(new int[]{d, y});
                }
                if (l >= 0 && maze[x][l] == '.' && dist[x][l] == Integer.MAX_VALUE) {
                    dist[x][l] = curr + 1;
                    q.addLast(new int[]{x, l});
                }
                if (r < n && maze[x][r] == '.' && dist[x][r] == Integer.MAX_VALUE) {
                    dist[x][r] = curr + 1;
                    q.addLast(new int[]{x, r});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NearestExit().nearestExit(new char[][]{
                {'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}
        }, new int[]{1, 0}));
    }
}
