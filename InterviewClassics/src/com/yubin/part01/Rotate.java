package com.yubin.part01;

/**
 * @author MIIAMOR
 * @date 2021/6/24 9:38
 * medium
 */
public class Rotate {
    /**
     * 只在原地修改矩阵
     * 本题难点是坐标变换
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int num, numNext;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int index1 = i, index2 = j;

                num = matrix[index1][index2];
                index1 = index2;
                index2 = N - 1 - i;
                numNext = matrix[index1][index2];
                matrix[index1][index2] = num;

                num = numNext;
                index1 = index2;
                index2 = N - 1 - j;
                numNext = matrix[index1][index2];
                matrix[index1][index2] = num;

                num = numNext;
                index1 = index2;
                index2 = i;
                numNext = matrix[index1][index2];
                matrix[index1][index2] = num;

                matrix[i][j] = numNext;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int N = matrix.length;
        int[][] rotateMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotateMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }
        matrix = rotateMatrix;
    }

    public static void main(String[] args) {
        new Rotate().rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
        new Rotate().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }
}
