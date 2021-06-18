package com.yubin.easy.part2;

import java.util.LinkedList;
import java.util.List;

public class ReadBinaryWatch {
    private int[] nums = new int[]{1, 2, 4, 8, 16, 32, 1, 2, 4, 8};
    private boolean[] light = new boolean[nums.length];
    private int size = nums.length;
    private List<String> res = null;

    public List<String> readBinaryWatch(int turnedOn) {
        res = new LinkedList<>();
        backtracking(turnedOn, 0);
        return res;
    }

    /**
     * @param left 剩下的可用的灯
     */
    private void backtracking(int left, int index) {
        if (left == 0) {
            int hour = 0, minute = 0;
            for (int i = 0; i < light.length; i++) {
                if (i < 6)
                    minute += (light[i] ? nums[i] : 0);
                else
                    hour += (light[i] ? nums[i] : 0);
            }
            if (hour < 12 && minute < 60) {
                if (minute < 10) res.add(hour + ":0" + minute);
                else res.add(hour + ":" + minute);
            }
            return;
        }
        for (int i = index; i < size; i++) {
            if (i + left > size) return;
            light[i] = true;
            backtracking(left - 1, i + 1);
            light[i] = false;
        }
    }

    public void test() {
        for (String s : readBinaryWatch(2)) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        new ReadBinaryWatch().test();
    }
}
