package com.yubin.part2;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    /**
     * 按照每个区间的右侧边界升序排序<br>
     * 然后依次向右遍历，如果已经存在的右边界比下一个区间的左边界还要大，说明一定有重叠，那么删除区间<br>
     * 否则重新记录新的右边界
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int res = 0;
        int right = intervals[0][1];//记录右边界
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                continue;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eoi = new EraseOverlapIntervals();
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eoi.eraseOverlapIntervals(intervals));
    }
}
