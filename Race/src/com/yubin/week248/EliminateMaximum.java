package com.yubin.week248;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/7/4 18:54
 */
public class EliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        // 计算每个怪物到达的时间，然后遍历时间，一分钟消灭一个
        // 当怪物到达的时间少于当前的时间，说明此时无法消灭这个怪物
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = 1.0 * dist[i] / speed[i];
        }
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            if (i >= time[i]) return i;
        }
        return n;
    }
}
