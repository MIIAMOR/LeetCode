package com.yubin.part10;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/7/3 14:14
 */
public class GroupAnagrams {
    private Map<String, Integer> map;
    private Integer index;
    private List<List<String>> res;

    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();
        res = new ArrayList<>();
        index = 0;
        for (String str : strs) {
            putIn(str);
        }
        return res;
    }

    public void putIn(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String ss = String.valueOf(chars);
        if (map.containsKey(ss)) {
            res.get(map.get(ss)).add(s);
        } else {
            map.put(ss, index++);
            List<String> list = new ArrayList<>();
            list.add(s);
            res.add(list);
        }
    }
}
