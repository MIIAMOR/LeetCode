package com.yubin.easy.part3;

/**
 * @author MIIAMOR
 * @date 2021/7/9 13:44
 */
public class FloodFill {
    private int preColor, newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        preColor = image[sr][sc];
        this.newColor = newColor;
        if (preColor == newColor) return image;
        dfs(image, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int i, int j) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != preColor) return;
        image[i][j] = newColor;
        dfs(image, i + 1, j);
        dfs(image, i - 1, j);
        dfs(image, i, j + 1);
        dfs(image, i, j - 1);
    }
}
