package com.yubin.medium.part2;

import java.util.Arrays;

public class FindMinArrowShots {
    /**
     * 贪心思想：从最低的气球向上看
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return 0;
        });//按照气球的最高点进行排序
        int high = points[0][1];//记录第一个气球的高点位置
        int res = 1;
        //迭代的过程就是判断每一枪在可以打到目前剩下气球中最矮的一个的同时至少还可以打中少个气球
        for (int[] point : points) {
            if (point[0] <= high)
                continue;
            high = point[1];
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        FindMinArrowShots mas = new FindMinArrowShots();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points1 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points2 = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] points3 = new int[][]{{1, 2}, {4, 5}, {1, 5}};
        System.out.println(mas.findMinArrowShots(points));
        System.out.println(mas.findMinArrowShots(points1));
        System.out.println(mas.findMinArrowShots(points2));
        System.out.println(mas.findMinArrowShots(points3));
    }
}
