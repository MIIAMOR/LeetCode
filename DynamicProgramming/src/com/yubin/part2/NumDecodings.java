package com.yubin.part2;

public class NumDecodings {
    /**
     * 动态规划算法<br>
     * 设置一个dp[]数组用于记录到s[i]处时解码的串数量<br>
     * 从左到右查看时数字的时候，由于字母与数字的映射是1-26，那么需要考虑两种位数的情况<br>
     * 1. 只有一位数进行字符扩展的时候，那么i处能得到的串数量就是i-1处的串数量<br>
     * 这里需要注意的是0的情况，0不会构成字符，所以1位扩展在s[i]=='0'时无效<br>
     * 2. 有两位数字进行扩展的时候，那么i出可以得到的串数量，就是i-2出已经知道的串数量<br>
     * 这里需要注意的是，由于1-26才会对应出字符，所以需要进行数的大小判断<p></p>
     * 这里由于值需要用到dp[i]前面的两个数，所以，可以不定义数组
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        int res = 0, pre1 = 1, pre2 = 1;
        int num;
        for (int i = 0; i < s.length(); i++) {
            res = 0;
            num = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (num >= 1 && num <= 9) {
                res += pre1;
            }
            if (i - 1 >= 0 && s.charAt(i - 1) != '0') {
                num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num >= 1 && num <= 26) {
                    res += pre2;
                }
            }
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    /**
     * 时间内复杂度终于优化到了100%<br>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了100.00% 的用户<br>
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 98.86% 的用户
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int res = 0, pre1 = 1, pre2 = 1;
        for (int i = 0; i < s.length(); i++) {
            res = 0;
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                res += pre1;
            }
            if (i - 1 >= 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))) {
                res += pre2;
            }
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        NumDecodings nd = new NumDecodings();
        System.out.println(nd.numDecodings1("111"));
        System.out.println(nd.numDecodings1("12"));
        System.out.println(nd.numDecodings1("226"));
        System.out.println(nd.numDecodings1("0"));
        System.out.println(nd.numDecodings1("06"));
        System.out.println(nd.numDecodings2("111"));
        System.out.println(nd.numDecodings2("12"));
        System.out.println(nd.numDecodings2("226"));
        System.out.println(nd.numDecodings2("0"));
        System.out.println(nd.numDecodings2("06"));
    }
}