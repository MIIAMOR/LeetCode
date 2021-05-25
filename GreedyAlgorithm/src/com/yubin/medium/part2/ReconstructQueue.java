package com.yubin.medium.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    /**
     * 对数组进行排序（按照h降序）
     * 每次插入的数据都是剩余列表中身高最高的一个，那么已经插入的就是不小于当前身高的身高
     * 那么插入的位置就是在k
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p2[0] == p1[0]) return p1[1] - p2[1];
            return p2[0] - p1[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p2[0] == p1[0]) return p1[1] - p2[1];
            return p2[0] - p1[0];
        });
        int[][] res = new int[people.length][2];
        int size = 0;
        for (int i = 0; i < people.length; i++) {
            System.arraycopy(res, people[i][1], res, people[i][1] + 1, size - people[i][1]);
            res[people[i][1]] = people[i];
            size++;
        }
        return res;
    }

    /**
     * 对数组进行排序（按照k升序，k相同时h升序）
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        int[][] res = new int[people.length][2];
        //O(n)
        System.arraycopy(people, 0, res, 0, people.length);
        //O(n*logn)
        Arrays.sort(res, (p1, p2) -> {
            if (p1[1] > p2[1]) return 1;
            else if (p1[1] < p2[1]) return -1;
            else {
                if (p1[1] == 0) {
                    if (p1[0] > p2[0]) return 1;
                    else if (p1[0] < p2[0]) return -1;
                    else return 0;
                } else {
                    if (p1[0] < p2[0]) return 1;
                    else if (p1[0] > p2[0]) return -1;
                    else return 0;
                }
            }
        });
        //O(n^3)
        for (int i = 0; i < res.length; i++) {
            int count = 0;
            if (res[i][1] > 0) {
                for (int j = 0; j < res.length; j++) {
                    if (res[j][0] >= res[i][0]) count++;
                    if (count == res[i][1]) {
                        int[] temp = res[i];
                        for (int index = i; index > j; index--) {
                            res[index] = res[index - 1];
                        }
                        res[j + 1] = temp;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public void test() {
        int[][] p = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] p1 = new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        reconstructQueue1(p);
        reconstructQueue1(p1);
    }


    public static void main(String[] args) {
        new ReconstructQueue().test();
    }
}