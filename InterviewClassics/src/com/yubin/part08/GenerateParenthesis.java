package com.yubin.part08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/30 16:26
 */
public class GenerateParenthesis {
    private int status; // 记录括号状态，需要多少个右括号匹配
    private int left, right;// 左括号和右括号剩余的数量

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        sb.append('(');// 第一个只能是左括号
        left = n - 1;
        right = n;
        status = 1;
        backtracking(res, sb);
        return res;
    }

    private void backtracking(ArrayList<String> res, StringBuilder sb) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (status == 0 || left > 0) {
            left--;
            status++;
            sb.append('(');
            backtracking(res, sb);
            sb.deleteCharAt(sb.length() - 1);
            status--;
            left++;
        }
        if (status > 0 && right > 0) {
            right--;
            status--;
            sb.append(')');
            backtracking(res, sb);
            sb.deleteCharAt(sb.length() - 1);
            status++;
            right++;
        }
    }

    public static void main(String[] args) {
        for (String s : new GenerateParenthesis().generateParenthesis(5)) {
            System.out.println(s);
        }
    }
}
