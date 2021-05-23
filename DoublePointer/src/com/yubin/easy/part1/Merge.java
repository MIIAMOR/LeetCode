package com.yubin.easy.part1;

public class Merge {
    /**
     * 归并排序的嘛
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums1 = new int[m];
        System.arraycopy(nums1, 0, tempNums1, 0, m);
        int index = 0, i1 = 0, i2 = 0;
        while (i1 < m && i2 < n) nums1[index++] = tempNums1[i1] < nums2[i2] ? tempNums1[i1++] : nums2[i2++];
        while (i1 < m) nums1[index++] = tempNums1[i1++];
        while (i2 < n) nums1[index++] = nums2[i2++];
    }
}
