package com.yubin.medium.part2;

public class Exist {
    private char[][] board = null;
    private char[] words = null;
    private int m = 0;
    private int n = 0;
    private int len = 0;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        if (len > m * n) return false;
        words = word.toCharArray();
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    if (len == 1 || exist(i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * @param i     起始位置的坐标
     * @param j     起始位置的坐标
     * @param index 当前应该寻找的字符在单词中的下标
     * @return
     */
    private boolean exist(int i, int j, int index) {
        if (index >= len) return true;
        if (board[i][j] != words[index]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        if (i + 1 < m && exist(i + 1, j, index + 1))
            return true;
        if (i - 1 >= 0 && exist(i - 1, j, index + 1))
            return true;
        if (j + 1 < n && exist(i, j + 1, index + 1))
            return true;
        if (j - 1 >= 0 && exist(i, j - 1, index + 1))
            return true;
        board[i][j] = c;
        return false;
    }

    public void test() {
        System.out.println(exist(new char[][]{
                {'a', 'a'},
        }, "aa"));
    }

    public static void main(String[] args) {
        new Exist().test();
    }
}
