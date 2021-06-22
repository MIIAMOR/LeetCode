package com.yubin.medium.part2;

public class UpdateMatrix {
    /**
     * 常规解法：
     * 初始化结果数组
     * 第一次遍历：把1的点设置为10000，0的带你设置为0
     * 之后对结果数组不停的遍历，一直到res中所有的值都不在变化为止
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) res[i][j] = 10000;
            }
        }
        while (true) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (res[i][j] > 0) {
                        int north = i - 1, south = i + 1, west = j - 1, east = j + 1;
                        int dis = 10000;
                        if (north >= 0) dis = Math.min(res[north][j] + 1, dis);
                        if (south < m) dis = Math.min(res[south][j] + 1, dis);
                        if (west >= 0) dis = Math.min(res[i][west] + 1, dis);
                        if (east < n) dis = Math.min(res[i][east] + 1, dis);
                        if (dis != res[i][j]) {
                            res[i][j] = dis;
                            count++;
                        }
                    }
                }
            }
            if (count == 0) break;
        }
        return res;
    }

    public int[][] updateMatrix1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) res[i][j] = 10000;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] > 0) {
                    int north = i - 1, west = j - 1;
                    if (north >= 0) res[i][j] = Math.min(res[north][j] + 1, res[i][j]);
                    if (west >= 0) res[i][j] = Math.min(res[i][west] + 1, res[i][j]);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i][j] > 0) {
                    int south = i + 1, east = j + 1;
                    if (south < m) res[i][j] = Math.min(res[south][j] + 1, res[i][j]);
                    if (east < n) res[i][j] = Math.min(res[i][east] + 1, res[i][j]);
                }
            }
        }
        return res;
    }

    public void test() {
        for (int[] matrix : updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}})) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for (int[] matrix : updateMatrix1(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}})) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new UpdateMatrix().test();
    }
}
