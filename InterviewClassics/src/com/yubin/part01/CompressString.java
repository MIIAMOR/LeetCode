package com.yubin.part01;

/**
 * @author MIIAMOR
 * @date 2021/6/24 9:11
 * easy
 */
public class CompressString {
    public String compressString(String S) {
        if (S == null) return null;
        if (S.length() == 0) return S;
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int count = 1;
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) count++;
            else {
                sb.append(pre).append(count);
                pre = chars[i];
                count = 1;
            }
        }
        sb.append(pre).append(count);
        return sb.length() < S.length() ? sb.toString() : S;
    }

    public static void main(String[] args) {
        new CompressString().compressString("Iaccoca");
    }
}
