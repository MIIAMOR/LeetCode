package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/7/6 21:06
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            for (int i = words[0].length() - 1; i >= 0; i--) {
                sb.append(words[0].charAt(i));
            }
        } else {
            for (String word : words) {
                sb.append(reverseWords(word)).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
