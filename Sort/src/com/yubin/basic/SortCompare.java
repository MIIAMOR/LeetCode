package com.yubin.basic;

import java.util.Arrays;
import java.util.Random;

public class SortCompare {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Integer[] nums = new Integer[20];
        int[] nums2 = new int[20];
        Random rd = new Random();

        System.out.println("\n shellSort ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(1000);
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Sort.shellSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n mergeSort ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(1000);
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Sort.mergeSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n quickSort ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(1000);
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Sort.quickSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n bucketSort ");
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = rd.nextInt(1000);
        }
        for (Integer num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();
        Sort.bucketSort(nums2, 10);
        for (Integer num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void test2() {
        int size = 5000000;
        int bounds = 10000000;
        Random rd = new Random();
        Integer[] nums1 = new Integer[size];
        Integer[] nums2 = new Integer[size];
        Integer[] nums3 = new Integer[size];
        Integer[] nums4 = new Integer[size];
        int[] nums5 = new int[size];
        for (int i = 0; i < size; i++) {
            nums1[i] = rd.nextInt(bounds);
            nums2[i] = nums1[i];
            nums3[i] = nums1[i];
            nums4[i] = nums1[i];
            nums5[i] = nums1[i];
        }
        long t1;
        long t2;
        t1 = System.currentTimeMillis();
        Arrays.sort(nums1);
        t2 = System.currentTimeMillis();
        System.out.println("系统的快速排序耗时: " + (t2 - t1) + " ms " + "规模: " + size);

        t1 = System.currentTimeMillis();
        Sort.quickSort(nums2);
        t2 = System.currentTimeMillis();
        System.out.println("自己的快速排序耗时: " + (t2 - t1) + " ms " + "规模: " + size);

        t1 = System.currentTimeMillis();
        Sort.shellSort(nums3);
        t2 = System.currentTimeMillis();
        System.out.println("自己的希尔排序耗时: " + (t2 - t1) + " ms " + "规模: " + size);

        t1 = System.currentTimeMillis();
        Sort.mergeSort(nums4);
        t2 = System.currentTimeMillis();
        System.out.println("自己的归并排序耗时: " + (t2 - t1) + " ms " + "规模: " + size);

        t1 = System.currentTimeMillis();
        Sort.bucketSort(nums5, bounds / Sort.GAP);
        t2 = System.currentTimeMillis();
        System.out.println("自己的桶排序耗时: " + (t2 - t1) + " ms " + "规模: " + size);
    }
}
