package com.yubin.hard.part1;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {
    /**
     * 归并求解 O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> l = new ArrayList<>();
        int i1 = 0, i2 = 0;
        int mid1, mid2;
        if ((n + m) % 2 == 0) {
            //偶数情况
            mid2 = (n + m) / 2;
            mid1 = mid2 - 1;
        } else {
            //奇数情况
            mid2 = (n + m) / 2;
            mid1 = mid2;
        }
        while (i1 < m && i2 < n) {
            if (nums1[i1] < nums2[i2]) l.add(nums1[i1++]);
            else l.add(nums2[i2++]);
        }
        while (i1 < m) l.add(nums1[i1++]);
        while (i2 < n) l.add(nums2[i2++]);
        return (l.get(mid1) + l.get(mid2)) / 2.0;
    }

    /**
     * 二分查找  (不会做)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return 0;
    }


    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static void main(String[] args) {
        new FindMedianSortedArrays().test();
    }
}
