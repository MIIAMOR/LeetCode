package com.yubin.medium.part1;

public class LongestPalindrome {
    /**
     * <p>动态规划算法</p>
     * <p>1.建立一个dp数组记录dp[j]记录的是以j下标为结尾的最长回文串的开始位置</p>
     * <p>2.如何递推求出每个dp[j]的值</p>
     * <p> 情况1：dp[j+1] = dp[dp[j]-1],这种情况直接使得dp[j+1] = dp[j]-1</p>
     * <p> 情况2：如果没能向两侧扩展，那么需要重新求出最长回文子串<br/>
     * (解决方法：设置两个下标left = dp[j],right = j+1<br>
     * 如果str[lef]==str[right]让left++的同时让right--<br>
     * 如果遇到str[lef]！=str[right]，让right回归初始值，left不变<br>
     * 当left==right的时候，就可以记录dp数组了
     * </p>
     *
     * @param s 要求的字符串
     * @return 最长的回文子串
     */
    public String longestPalindrome1(String s) {
        if (s == null) {
            return null;
        }
        int[] dp = new int[s.length()];//建立记录数组
        char[] chars = s.toCharArray();//拆分字符串为一个字符数组
        dp[0] = 0;//初始化dp[0]为0
        //动态求得每一个数组的值
        for (int i = 1; i < chars.length; i++) {
            //边界判断 索引没有变为负数
            if (dp[i - 1] - 1 >= 0 && chars[i] == chars[dp[i - 1] - 1]) {
                //情况1 当前字符串等于上一个字符串的上
                dp[i] = dp[i - 1] - 1;
            } else {
                int left = dp[i - 1], right = i, index = dp[i - 1];
                while (right - left >= 1) {
                    if (chars[left] == chars[right]) {
                        left++;
                        right--;
                    } else {
                        right = i;
                        left++;
                        index = left;
                        if (index == i) break;
                    }
                }
                dp[i] = index;
            }
        }
        //遍历获取最大的回文串
        int begin = 0, end = 0, len = 0;
        for (int i = 0; i < dp.length; i++) {
            if (i - dp[i] > len) {
                begin = dp[i];
                end = i;
                len = i - dp[i];
            }
        }
        return s.substring(begin, end + 1);
    }

    /**
     * 中间向两侧扩展法，思路简单易懂
     *
     * @param s 要求的字符串
     * @return 最长的回文子串
     */
    public String longestPalindrome2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            str1.delete(0, str1.length()).append(extend(s, i, i));//奇数扩展
            str2.delete(0, str2.length()).append(extend(s, i, i + 1));//偶数扩展
            if (res.length() < str1.length() || res.length() < str2.length()) {
                res.delete(0, res.length()).append(str1.length() > str2.length() ? str1 : str2);
            }
        }
        return res.toString();
    }

    /**
     * 从中间向两侧扩展，注意<br>
     * 回文串是奇数还是偶数<br>
     *
     * @param s     待求的字符串
     * @param left  以该索引向两边扩展
     * @param right 以该索引向两边扩展
     * @return 中间向两侧扩展的最大回文子串
     */
    private String extend(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome1("asddsa"));
        System.out.println(lp.longestPalindrome1("cbbdd"));
        System.out.println(lp.longestPalindrome1("cb"));
        System.out.println(lp.longestPalindrome1("ababababa"));
        System.out.println(lp.longestPalindrome1("asddsa"));
        System.out.println(lp.longestPalindrome1(null));
        System.out.println(lp.longestPalindrome2("asddsa"));
        System.out.println(lp.longestPalindrome2("cbbdd"));
        System.out.println(lp.longestPalindrome2("cb"));
        System.out.println(lp.longestPalindrome2("ababababa"));
        System.out.println(lp.longestPalindrome2("babad"));
        System.out.println(lp.longestPalindrome2("bb"));
        System.out.println(lp.longestPalindrome2("sss"));
        System.out.println(lp.longestPalindrome2(""));
        System.out.println(lp.longestPalindrome2(null));
    }
}
