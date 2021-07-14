package com.yubin.part10;

import java.util.Collections;

/**
 * @author MIIAMOR
 * @date 2021/7/5 19:01
 */
public class FindString {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            while (mid > left && words[mid].equals("")) mid--;
            if (s.equals(words[mid])) return mid;
            else if (s.compareTo(words[mid]) > 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int findString1(String[] words, String s) {
        int index = 0;
        for (String word : words) {
            if (word.equals(s)) return index;
            index++;
        }
        return -1;
    }
}
