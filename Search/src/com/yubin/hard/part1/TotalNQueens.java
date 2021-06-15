package com.yubin.hard.part1;

public class TotalNQueens {
    public int totalNQueens(int n) {
        return new SolveNQueens().solveNQueens(n).size();
    }
}