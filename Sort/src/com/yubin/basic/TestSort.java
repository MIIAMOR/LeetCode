package com.yubin.basic;

import java.util.Comparator;
import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        Integer[] nums = new Integer[10000];
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(100000);
        }

        long start = System.currentTimeMillis();
        Sort.shellSort(nums);
        long end = System.currentTimeMillis();
        System.out.println("shell排序运行时间" + (end - start) + "ms");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(100000);
        }

        start = System.currentTimeMillis();
        Sort.shellSort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        end = System.currentTimeMillis();
        System.out.println("shell排序运行时间" + (end - start) + "ms");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(1000000);
        }

        start = System.currentTimeMillis();
        Sort.quickSort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        end = System.currentTimeMillis();
        System.out.println("quick排序运行时间" + (end - start) + "ms");
    }

    public static void main1(String[] args) {
        Integer[] nums = new Integer[10];
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(100);
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        long start = System.currentTimeMillis();
        Sort.shellSort(nums);
        long end = System.currentTimeMillis();
        System.out.println("shell排序运行时间" + (end - start) + "ms");

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        Sort.mergeSort(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Sort.mergeSort(nums, (Comparator<Integer>) (o1, o2) -> o2 - o1);
        Sort.quickSort(nums, (Comparator<Integer>) (o1, o2) -> o2 - o1);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
