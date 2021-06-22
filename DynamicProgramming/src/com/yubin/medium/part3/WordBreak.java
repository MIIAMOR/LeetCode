package com.yubin.medium.part3;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    /**
     * wordInList[i]代表i以前的单词是否都可以被划分
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] wordInList = new boolean[len + 1];
        wordInList[0] = true;
        for (int i = 1; i < len + 1; i++) {
            for (String word : wordDict) {
                int lenOfWord = word.length();
                if (i >= lenOfWord) {
                    String subWord = s.substring(i - lenOfWord, i);
                    if (subWord.equals(word))
                        wordInList[i] = wordInList[i] || wordInList[i - lenOfWord];
                }
            }
        }
        return wordInList[len];
    }


    /**
     * dfs搜索
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (String word : wordDict) {
            int lenOfWord = word.length();
            if (s.length() < lenOfWord) continue;
            if (word.equals(s.substring(0, lenOfWord)))
                if (wordBreak(s.substring(lenOfWord), wordDict))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("cars",
                Arrays.asList("car", "ca", "rs")));
    }
}