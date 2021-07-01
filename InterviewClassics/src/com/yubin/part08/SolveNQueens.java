package com.yubin.part08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/7/1 13:30
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        return solveNQueens1(n);
    }

    /**
     * dfs搜索
     */
    // 行标记(可以不需要)、列标记 左斜标记、右斜标记（用于记录对角线）
    private boolean[] cols, obliqueLeft, obliqueRight;
    private char[][] board;// 棋盘
    private int N;// 皇后数量
    private List<List<String>> res;

    private List<List<String>> solveNQueens1(int n) {
        N = n;
        cols = new boolean[n];
        res = new ArrayList<>();
        // 对角线的映射方式
        obliqueLeft = new boolean[2 * n + 1];// 左下到右上对角线 index = i + j
        obliqueRight = new boolean[2 * n + 1];// 左上到右下对角线 index = n - i + j - 1
        board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        dfs(0);
        return res;
    }

    /**
     * @param row 要在第row行安排皇后
     */
    private void dfs(int row) {
        // 递归出口设置
        if (row == N) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(String.valueOf(chars));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < N; i++) {
            // 当前这个点所在的列 行 和 两个对角线都是有效的
            if (!cols[i] && !obliqueLeft[row + i] && !obliqueRight[N - row + i - 1]) {
                // 把这个点的对应的行列对角线有效性去除
                cols[i] = obliqueLeft[row + i] = obliqueRight[N - row + i - 1] = true;
                board[row][i] = 'Q';
                dfs(row + 1);
                // 恢复状态
                board[row][i] = '.';
                cols[i] = obliqueLeft[row + i] = obliqueRight[N - row + i - 1] = false;
            }
        }
    }
}
