package com.yubin.medium.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FrequencySort {
    /**
     * 计数排序
     */
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<Count> counts = new ArrayList<>();
        counts.add(new Count(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i])
                counts.add(new Count(chars[i]));
            else
                counts.get(counts.size() - 1).count++;
        }
        Collections.sort(counts);
        StringBuffer sb = new StringBuffer();
        for (Count count : counts) {
            for (int i = 0; i < count.count; i++) {
                sb.append(count.c);
            }
        }
        return sb.toString();
    }

    class Count implements Comparable {
        public char c;
        public int count = 1;

        public Count(char c) {
            this.c = c;
        }

        @Override
        public int compareTo(Object o) {
            Count c = (Count) o;
            return c.count - this.count;
        }
    }
}
