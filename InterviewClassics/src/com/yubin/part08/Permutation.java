package com.yubin.part08;

/**
 * @author MIIAMOR
 * @date 2021/6/30 14:13
 */
public class Permutation {
    private char[] chars;
    private StringBuilder sb;
    private boolean[] visited;
    private int len, index;
    private String[] res;

    public String[] permutation(String S) {
        chars = S.toCharArray();
        len = chars.length;
        index = 0;
        visited = new boolean[len];
        sb = new StringBuilder();
        res = new String[getLen(len)];
        backtracking(0);
        return res;
    }

    private int getLen(int n) {
        if (n == 1) return 1;
        return getLen(n - 1) * n;
    }

    private void backtracking(int currLen) {
        if (currLen == len) {
            res[index++] = sb.toString();
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(chars[i]);
                backtracking(currLen + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
