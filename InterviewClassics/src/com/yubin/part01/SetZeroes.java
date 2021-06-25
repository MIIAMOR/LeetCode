package com.yubin.part01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/6/24 10:37
 * medium
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        Set<Integer> cols = new HashSet<>(), rows = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    cols.add(j);
                    rows.add(i);
                }
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < M; i++) {
                matrix[i][col] = 0;
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < N; i++) {
                matrix[row][i] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        boolean[] rows = new boolean[M], cols = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rows[i] || cols[j]) matrix[i][j] = 0;
            }
        }
    }
}
