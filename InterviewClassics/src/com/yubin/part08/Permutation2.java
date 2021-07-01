package com.yubin.part08;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/6/30 16:01
 */
public class Permutation2 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        int len = chars.length;
        boolean[] visited = new boolean[len];
        backtracking(chars, visited, sb, len, list, 0);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void backtracking(char[] chars, boolean[] visited, StringBuilder sb, int len, ArrayList<String> list, int currLen) {
        if (currLen == len) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(chars[i]);
            backtracking(chars, visited, sb, len, list, currLen + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
            while (i + 1 < len && (chars[i] == chars[i + 1])) i++;
        }
    }

    public static void main(String[] args) {
        for (String s : new Permutation2().permutation("awake")) {
            System.out.println(s);
        }
    }
}
