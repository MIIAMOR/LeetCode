package com.yubin.medium.part5;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/7/13 13:25
 */
public class LetterCasePermutation {
    private List<String> res;
    private int n;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        n = s.length();
        char[] chars = s.toCharArray();
        backtracking(chars, 0);
        return res;
    }

    private void backtracking(char[] chars, int index) {
        if (index == n) {
            res.add(String.valueOf(chars));
            return;
        }
        backtracking(chars, index + 1);
        if (chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] += 32;
            backtracking(chars, index + 1);
            chars[index] -= 32;
        }
        if (chars[index] >= 'a' && chars[index] <= 'z') {
            chars[index] -= 32;
            backtracking(chars, index + 1);
            chars[index] += 32;
        }
    }
}
