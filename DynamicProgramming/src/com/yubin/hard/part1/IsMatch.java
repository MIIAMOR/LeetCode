package com.yubin.hard.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/22
 */
public class IsMatch {
    private boolean match(char[] c1, char[] c2, int i, int j) {
        if (i == 0) return false;
        if (c2[j - 1] == '.') return true;
        return c1[i - 1] == c2[j - 1];
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] charS = s.toCharArray(), charP = p.toCharArray();
        // dp[i][j]表示的是s的前i个字符可以有正则表达式的前j个字符匹配得到
        boolean[][] dp = new boolean[m + 1][n + 1];// 这里初始化默认为false
        // 设置为true 默认0串可以匹配0串
        dp[0][0] = true;
        /*
         * '*'字符无法单独出现，必定前面会出现一个字符
         * 分情况讨论：
         * 1. 在两个串中都遇到了普通字符
         *      dp[i][j] = dp[i - 1][j - 1]  s[i] == p[j]时
         *      dp[i][j] = false s[i] != p[j]时
         * 2. 当在p串中遇到了 . 表示可以匹配任意字符
         *      dp[i][j] = dp[i - 1][j - 1] 成立
         * 3. 当遇到了 * 时，这表明 * 前面的串一定普通字符或者 .
         *    这表示我们可以对p[j - 1]处的字符匹配数次
         *      这里比如放弃一次 * 匹配 则 dp[i][j] = dp[i][j - 2]
         *      如果选择匹配：
         *          1次： dp[i][j] = dp[i - 1][j - 2]
         *          2次： dp[i][j] = dp[i - 2][j - 2]
         *          3次： dp[i][j] = dp[i - 3][j - 2]...
         *      但是当我们使用 2次 匹配且二次匹配也有效的话 说明 1次 匹配也是有效的
         *      那么dp[i - 1][j]为真
         *      同理当我们使用 3次 匹配且二次匹配也有效的话 说明 2次 匹配也是有效的
         *      那么dp[i - 2][j]为真
         *
         *      那么dp[i][j] = dp[i - 1][j]
         *
         */
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 遇到了 * ，z则需要考虑的是前面的字符匹配情况
                if (charP[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];//默认零匹配情况
                    if (match(charS, charP, i, j - 1))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                } else {
                    if (match(charS, charP, i, j))
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 空间优化
     */
    public boolean isMatch1(String s, String p) {
        int m = s.length(), n = p.length();
        char[] charS = s.toCharArray(), charP = p.toCharArray();
        // dp[i][j]表示的是s的前i个字符可以有正则表达式的前j个字符匹配得到
        boolean[] preDp = new boolean[n + 1];// 这里初始化默认为false
        boolean[] currDp = new boolean[n + 1];// 这里初始化默认为false
        // 设置为true 默认0串可以匹配0串
        currDp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 遇到了 * ，z则需要考虑的是前面的字符匹配情况
                if (charP[j - 1] == '*') {
                    currDp[j] = currDp[j - 2];//默认零匹配情况
                    if (match(charS, charP, i, j - 1))
                        currDp[j] = currDp[j] || preDp[j];
                } else {
                    if (match(charS, charP, i, j))
                        currDp[j] = preDp[j - 1];
                }
            }
            preDp = currDp;
            currDp = new boolean[n + 1];
        }
        return preDp[n];
    }

    /**
     * 使用回溯算法
     */
    private char[] cS, cP = null;
    private boolean[] isStar = null;
    private int m, n;

    public boolean isMatch2(String s, String p) {
        m = s.length();
        n = p.length();
        cS = s.toCharArray();
        cP = new char[n];
        isStar = new boolean[n];
        int index = 0;
        // 为正则表达式中带*的字符打上标记
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (c == '*') isStar[index - 1] = true;
            else cP[index++] = c;
        }
        n = index;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == m) {
            if (j == n) return true;
            else if (j < n && isStar[j]) {
                return dfs(i, j + 1);
            }
            return false;
        }
        if (j >= n) return false;

        char c1 = cS[i], c2 = cP[j];

        // 带 * 的字符，匹配时可以选择匹配或者跳过
        if (isStar[j]) {
            boolean flag = false;
            if (c2 == '.' || c1 == c2)
                flag = dfs(i + 1, j);
            if (flag) return true;
            return dfs(i, j + 1);
        } else {
            if (c2 == '.' || c1 == c2)
                return dfs(i + 1, j + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsMatch().isMatch2("aa", "a"));
        System.out.println(new IsMatch().isMatch2("a", "ab*c*"));
        System.out.println(new IsMatch().isMatch2("aaa", "ab*a*c*a"));
        System.out.println(new IsMatch().isMatch2("aab", "c*a*bd"));
        System.out.println(new IsMatch().isMatch2("ab", "a*b"));
    }
}
