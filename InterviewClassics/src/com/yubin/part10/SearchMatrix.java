package com.yubin.part10;

/**
 * @author MIIAMOR
 * @date 2021/7/5 19:49
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        int rows = matrix.length;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (num == target) return true;
            }
        }
        return false;
    }
}
