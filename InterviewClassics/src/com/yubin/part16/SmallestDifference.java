package com.yubin.part16;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/7/13 19:48
 */
public class SmallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long res = Integer.MAX_VALUE;
        int left1 = 0, left2 = 0;
        int n1 = a.length, n2 = b.length;
        while (left1 < n1 && left2 < n2) {
            res = Math.min(res, Math.abs((long) a[left1] - b[left2]));
            if (a[left1] < b[left2]) left1++;
            else left2++;
        }
        while (left1 < n1) {
            res = Math.min(res, Math.abs(a[left1] - b[left2 - 1]));
            left1++;
        }
        while (left2 < n2) {
            res = Math.min(res, Math.abs(a[left1 - 1] - b[left2]));
            left2++;
        }
        return (int) res;
    }
}
