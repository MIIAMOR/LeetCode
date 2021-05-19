package com.yubin.basic;

import java.util.Comparator;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Integer[] nums = new Integer[30];
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(100);
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
        Sort.mergeSort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
