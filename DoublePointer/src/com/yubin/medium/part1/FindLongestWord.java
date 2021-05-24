package com.yubin.medium.part1;

import java.util.ArrayList;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String s1 : dictionary) {
            if (res.length() > s1.length()) continue;
            if (isIn(s, s1)) {
                if (res.length() < s1.length()) {
                    res = s1;
                } else if (s1.compareTo(res) < 0) {
                    res = s1;
                }
            }
        }
        return res;
    }

    public String findLongestWord1(String s, List<String> dictionary) {
        String res = "";
        for (String s1 : dictionary) {
            if (res.length() > s1.length()) continue;
            if (isSub(s, s1)) {
                if (res.length() < s1.length()) {
                    res = s1;
                } else if (s1.compareTo(res) < 0) {
                    res = s1;
                }
            }
        }
        return res;
    }

    /**
     * 判断子串的函数
     *
     * @param target
     * @param s
     * @return
     */
    private boolean isSub(String target, String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = target.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断smallStr是否在bigStr中
     *
     * @param bigStr
     * @param smallStr
     * @return
     */
    private boolean isIn(String bigStr, String smallStr) {
        if (smallStr.length() > bigStr.length()) return false;
        int bigLeft = 0, smallLeft = 0;

        while (smallLeft < smallStr.length() && bigLeft < bigStr.length()) {
            if (smallStr.charAt(smallLeft) == bigStr.charAt(bigLeft++))
                smallLeft++;
        }

        return smallLeft == smallStr.length();
    }

    public static void main(String[] args) {
        FindLongestWord flw = new FindLongestWord();//s = "abpcplea", d = ["ale","apple","monkey","plea"]

        String s1 = "abpcplea";
        List<String> dic1 = new ArrayList<>();
        dic1.add("ale");
        dic1.add("apple");
        dic1.add("monkey");
        dic1.add("plea");
        System.out.println(flw.findLongestWord(s1, dic1));

        String s2 = "abpcplea";
        List<String> dic2 = new ArrayList<>();
        dic2.add("a");
        dic2.add("c");
        dic2.add("b");
        System.out.println(flw.findLongestWord(s2, dic2));
        System.out.println(flw.findLongestWord1(s2, dic2));
        System.out.println(flw.isIn("biggg", "biga"));
    }
}
