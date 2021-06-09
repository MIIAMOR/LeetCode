package com.yubin.easy.part1;

import java.util.*;

public class Intersection {
    /**
     * 排序对比法 不重复
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) i1++;
            else if (nums1[i1] > nums2[i2]) i2++;
            else {
                nums.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        int[] res = new int[nums.size()];
        int i = 0;
        for (Integer num : nums) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 可重复版本
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) i1++;
            else if (nums1[i1] > nums2[i2]) i2++;
            else {
                nums.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        int[] res = new int[nums.size()];
        int i = 0;
        for (Integer num : nums) {
            res[i++] = num;
        }
        return res;
    }

    public void test() {
        intersection(new int[]{1, 2}, new int[]{2});
        intersection1(new int[]{1, 2}, new int[]{2});
    }

    public static void main(String[] args) {
        new Intersection().test();
    }
}
