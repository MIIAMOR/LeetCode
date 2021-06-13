package com.yubin.medium.part2;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    private LinkedList<Character> stack = null;
    private LinkedList<String> res = null;
    private StringBuilder sb = null;
    /**
     * 左括号的剩余数量
     * 右括号的剩余数量
     */
    private int leftNum = 0;
    private int rightNum = 0;

    public List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        stack = new LinkedList<>();
        res = new LinkedList<>();
        leftNum = rightNum = n;
        backtracking();
        return res;
    }

    /**
     * 其中stack用于记录状态，判断此时加入左括号后者右括号是否合法
     * sb记录当前的括号拼接状态
     */
    private void backtracking() {
        if (leftNum == 0 && rightNum == 0) {
            res.add(sb.toString());
            return;
        }
        if (stack.size() == 0 || leftNum > 0) {
            stack.addLast('(');
            sb.append('(');
            leftNum--;
            backtracking();
            sb.deleteCharAt(sb.length() - 1);
            stack.removeLast();
            leftNum++;
        }
        if (stack.size() > 0 && rightNum > 0) {
            stack.removeLast();
            sb.append(')');
            rightNum--;
            backtracking();
            sb.deleteCharAt(sb.length() - 1);
            stack.addLast('(');
            rightNum++;
        }
    }
}
