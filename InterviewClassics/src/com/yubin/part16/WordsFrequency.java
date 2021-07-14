package com.yubin.part16;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/7/13 16:38
 */
public class WordsFrequency {
    Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        int index = 0;
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
