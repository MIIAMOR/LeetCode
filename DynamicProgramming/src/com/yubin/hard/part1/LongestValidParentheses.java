package com.yubin.hard.part1;

import java.util.LinkedList;

public class LongestValidParentheses {
    /**
     * 栈匹配法,遇到左括号，入栈，遇到右括号，检测匹配并弹栈
     * 半天才想明白，我好笨呀
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/32-zui-chang-you-xiao-gua-hao-fu-zhu-zha-1cqq/
     *
     * @param s
     * @return 连续的合法字符串长度
     */
    public int longestValidParentheses1(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) == '(' || s.charAt(stack.getLast()) == ')') {
                stack.addLast(i);
            } else {
                stack.removeLast();
                res = Math.max(res, stack.isEmpty() ? i + 1 : i - stack.getLast());
            }
        }
        return res;
    }

    /**
     * 解法思路来源：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') dp[i] = 0;
            else if (chars[i] == ')') {
                if ((i - 1) >= 0 && (chars[i - 1] == '(')) {
                    dp[i] = 2;
                    if (i - 2 >= 0) dp[i] = dp[i - 2] + 2;
                } else if (i - 1 >= 0 && chars[i - 1] == ')') {
                    //判断((...))形
                    if ((i - dp[i - 1] - 1 >= 0) && (chars[i - dp[i - 1] - 1] == '(')) {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0)
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses1("(()())"));
        System.out.println(lvp.longestValidParentheses1("(()"));
        System.out.println(lvp.longestValidParentheses1("()((()"));
        System.out.println(lvp.longestValidParentheses1("()(())"));
        System.out.println(lvp.longestValidParentheses1(")()())"));
        System.out.println(lvp.longestValidParentheses1(")()())()()("));

        System.out.println(lvp.longestValidParentheses2("(()())"));
        System.out.println(lvp.longestValidParentheses2("(()"));
        System.out.println(lvp.longestValidParentheses2("()((()"));
        System.out.println(lvp.longestValidParentheses2("()(())"));
        System.out.println(lvp.longestValidParentheses2(")()())"));
        System.out.println(lvp.longestValidParentheses2(")()())()()("));
    }
}
