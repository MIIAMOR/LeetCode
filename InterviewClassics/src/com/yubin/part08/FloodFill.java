package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/6/30 16:26
 */
public class FloodFill {
    private int m, n, preColor, newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        preColor = image[sr][sc];
        this.newColor = newColor;
        if (preColor == newColor) return image;
        dfs(image, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc) {
        image[sr][sc] = newColor;
        if (sr - 1 >= 0 && image[sr - 1][sc] == preColor) dfs(image, sr - 1, sc);
        if (sc - 1 >= 0 && image[sr][sc - 1] == preColor) dfs(image, sr, sc - 1);
        if (sr + 1 < m && image[sr + 1][sc] == preColor) dfs(image, sr + 1, sc);
        if (sc + 1 < n && image[sr][sc + 1] == preColor) dfs(image, sr, sc + 1);
    }
}
