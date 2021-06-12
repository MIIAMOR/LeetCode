package com.yubin.medium.part1;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    private final String[] digitsChar = new String[]{
            " ","!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "*+", "_", "#"
    };
    private StringBuilder sb = null;
    private List<String> res = null;
    private int len = 0;

    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if (digits.length() == 0) return res;
        sb = new StringBuilder();
        len = digits.length();
        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int index) {
        if (index == len) {
            res.add(sb.toString());
            return;
        }
        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < digitsChar[digit].length(); i++) {
            char c = digitsChar[digit].charAt(i);
            sb.append(c);
            dfs(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public void test() {
        letterCombinations("23");
    }

    public static void main(String[] args) {
        new LetterCombinations().test();
    }
}
