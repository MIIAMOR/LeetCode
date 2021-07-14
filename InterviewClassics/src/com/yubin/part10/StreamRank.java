package com.yubin.part10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/7/7 21:29
 */
public class StreamRank {
    private List<Integer> list;

    public StreamRank() {
        list = new ArrayList<>();
    }

    public void track(int x) {
        list.add(x);
    }

    public int getRankOfNumber(int x) {
        int count = 0;
        for (Integer i : list) {
            if (i <= x) count++;
        }
        return count;
    }
}
