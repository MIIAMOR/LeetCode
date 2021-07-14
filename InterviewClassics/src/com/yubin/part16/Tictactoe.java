package com.yubin.part16;

/**
 * @author MIIAMOR
 * @date 2021/7/13 18:35
 */
public class Tictactoe {
    public String tictactoe(String[] board) {
        int n = board.length;
        int empty = 0;// 记录空的数量
        int[] rows = new int[n], cols = new int[n];// 记录X和O
        int left = 0, right = 0;// 左斜和右斜的数量
        for (int i = 0; i < n; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char c = chars[j];
                if (c == 'X') {
                    rows[i]++;
                    cols[j]++;
                    if (i == j) left++;
                    if (i + j + 1 == n) right++;
                } else if (c == 'O') {
                    rows[i]--;
                    cols[j]--;
                    if (i == j) left--;
                    if (i + j + 1 == n) right--;
                } else {
                    empty++;
                    continue;
                }
                if (j == n - 1) {
                    if (rows[i] == n) return "X";
                    if (rows[i] == -n) return "O";
                }
                if (i == n - 1) {
                    if (cols[j] == n) return "X";
                    if (cols[j] == -n) return "O";
                }
            }
        }
        if (left == n || right == n) return "X";
        else if (left == -n || right == -n) return "O";
        else if (empty == 0) return "Draw";
        else return "Pending";
    }
}
