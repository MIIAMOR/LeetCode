package com.yubin.medium.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    /**
     * 贪心思想：按照左值从小到大的顺序排序
     * 然后遍历二维数组，每次更新右值
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < len; i++) {
            int[] curr = new int[2];
            int currLeft = intervals[i][0];
            int currRight = intervals[i][1];
            while (i < len && intervals[i][0] <= currRight) {
                currRight = Math.max(currRight, intervals[i][1]);
                i++;
            }
            curr[0] = currLeft;
            curr[1] = currRight;
            res.add(curr);
            i--;
        }
        int[][] ans = new int[res.size()][2];
        int index = 0;
        for (int[] re : res) {
            ans[index++] = re;
        }
        return ans;
    }

    public void test() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new Merge().test();
    }
}
