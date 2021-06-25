package com.yubin.part01;

/**
 * @author MIIAMOR
 * @date 2021/6/23 20:03
 * easy
 */
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') sb.append("%20");
            else sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String replaceSpaces1(String S, int length) {
        String s = S.substring(0, length);
        s = s.replace(" ", "%20");
        return s;
    }

    public String replaceSpaces2(String S, int length) {
        char[] chars = S.toCharArray();
        char[] res = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else res[index++] = chars[i];
        }
        return String.valueOf(res).trim();
    }
}
