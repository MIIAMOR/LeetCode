package com.yubin.medium.part5;

import java.util.ArrayList;
import java.util.List;

public class Solve {
    /**
     * 逆向思维，遍历边界的O，进行dfs，不能被dfs搜索到的就是内部O，可以变成X
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        if (m == 1 || n == 1) return;
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
            if (board[i][0] == 'O') dfs(board, i, 0);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'o') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'o';
        int north = i - 1, south = i + 1, west = j - 1, east = j + 1;
        dfs(board, north, j);
        dfs(board, south, j);
        dfs(board, i, west);
        dfs(board, i, east);
    }

    /**
     * 常规解法，遍历每一个字符，对每一个字符dfs
     */
    private List<int[]> index = null;
    private int m = 0;
    private int n = 0;

    public void solve1(char[][] board) {
        m = board.length;
        n = board[0].length;
        index = new ArrayList<>();
        List<List<int[]>> indexList = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();
        if (m == 1 || n == 1) return;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    flags.add(dfs1(board, i, j));
                    indexList.add(new ArrayList<>(index));
                    index.clear();
                }
            }
        }
        int len = flags.size();
        for (int i = 0; i < len; i++) {
            if (!flags.get(i)) {
                for (int[] indexes : indexList.get(i)) {
                    board[indexes[0]][indexes[1]] = 'O';
                }
            }
        }
    }

    private boolean dfs1(char[][] board, int i, int j) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) return false;
        index.add(new int[]{i, j});
        int north = i - 1, south = i + 1, west = j - 1, east = j + 1;
        boolean flag = true;
        board[i][j] = 'X';
        if (board[north][j] == 'O') flag = dfs1(board, north, j);
        if (board[south][j] == 'O') flag &= dfs1(board, south, j);
        if (board[i][west] == 'O') flag &= dfs1(board, i, west);
        if (board[i][east] == 'O') flag &= dfs1(board, i, east);
        return flag;
    }

    public void test() {
        solve(new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        });
        solve1(new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        });
    }

    public static void main(String[] args) {
        new Solve().test();
    }
}
