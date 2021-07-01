package com.yubin.week247;

/**
 * @author MIIAMOR
 * @date 2021/6/27 10:49
 */
public class RotateGrid {
    /**
     * 思路：获取每一层第一个点移动k（去除冗余移动次数）后的下标
     * 在依次把数据复制过去
     */
    private int m, n;
    private int destI, destJ;// 每个层级中第一个方块，旋转k次后的坐标

    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int[][] res = new int[m][n];
        int level = Math.min(m, n) / 2;
        for (int l = 0; l < level; l++) {
            rotateLevel(grid, res, k, l);
        }
        return res;
    }

    private void rotateLevel(int[][] grid, int[][] res, int k, int level) {
        int len = 2 * (m + n - 4 * level) - 4;// 当前层级中方块的数量
        rotateKthIndex(level, k, len);
        int[] oriIndex = new int[]{level, level};
        int[] nextIndex = new int[]{destI, destJ};
        for (int count = 0; count < len; count++) {
            res[nextIndex[0]][nextIndex[1]] = grid[oriIndex[0]][oriIndex[1]];
            nextIndex(oriIndex, level);
            nextIndex(nextIndex, level);
        }
    }

    private void rotateKthIndex(int level, int k, int len) {
        k %= len;// 去除冗余的移动次数
        int[] index = new int[]{level, level};
        for (int i = 0; i < k; i++) {
            nextIndex(index, level);
        }
        destI = index[0];
        destJ = index[1];
    }

    /**
     * 获取当前点移动一次后的下标
     */
    private void nextIndex(int[] index, int level) {
        int i = index[0], j = index[1];
        if (i == level) {
            if (j == level) index[0]++;
            if (j > level) index[1]--;
        } else if (i == m - 1 - level) {
            if (j < n - 1 - level) index[1]++;
            if (j == n - 1 - level) index[0]--;
        } else if (j == level) {
            if (i < m - 1 - level) index[0]++;
        } else if (j == n - 1 - level) {
            if (i > level) index[0]--;
        }
    }
}
