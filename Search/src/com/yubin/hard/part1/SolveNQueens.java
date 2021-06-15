package com.yubin.hard.part1;

import java.util.*;

public class SolveNQueens {
    private List<char[]> list = null;
    private List<List<String>> res = null;
    //列 左斜 右斜
    private boolean[] col = null;
    private boolean[] leftTilt = null;
    private boolean[] rightTilt = null;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        list = new LinkedList<>();
        col = new boolean[n];
        leftTilt = new boolean[2 * n - 1];
        rightTilt = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            list.add(c);
        }
        backtracking(0, n);
        return res;
    }

    /**
     * 由于皇后只能存在于一行
     *
     * @param row 在row行填充一个Q
     * @param n   共多少个皇后
     */
    private void backtracking(int row, int n) {
        if (row == n) {
            List<String> l = new LinkedList<>();
            for (char[] chars : list) {
                l.add(String.valueOf(chars));
            }
            res.add(l);
            return;
        }
        //对row行，判断这一列中可以填充皇后的点
        for (int i = 0; i < n; i++) {
            if (col[i] || leftTilt[n - 1 + row - i] || rightTilt[i + row])
                continue;
            list.get(row)[i] = 'Q';
            //设置列属性
            col[i] = leftTilt[n - 1 + row - i] = rightTilt[i + row] = true;
            backtracking(row + 1, n);//设置皇后过后在下一行中找可以放皇后的点
            //恢复状态，在当前行寻找其他可以放皇后的点
            col[i] = leftTilt[n - 1 + row - i] = rightTilt[i + row] = false;
            list.get(row)[i] = '.';
        }
    }

    public void test() {
        List<List<String>> ans = solveNQueens(10);
        for (List<String> re : ans) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println(ans.size());
    }

    public static void main(String[] args) {
        new SolveNQueens().test();
    }
}