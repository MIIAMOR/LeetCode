package com.yubin.priority_queue.basic.test;

import com.yubin.priority_queue.basic.PriorityQueue;

import java.util.Arrays;
import java.util.Random;

/**
 * @author MIIAMOR
 * @date 2021/6/20
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Random rd = new Random();
        int size = 50000;
        Integer[] nums1 = new Integer[size];
        Integer[] nums2 = new Integer[size];
        for (int i = 0; i < size; i++) {
            nums1[i] = rd.nextInt(size * 10);
            nums2[i] = nums1[i];
        }
        long s1, s2;
        s1 = System.currentTimeMillis();
        Arrays.sort(nums1);
        System.out.println(isSorted(nums1));
        s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) + "ms");

        s1 = System.currentTimeMillis();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (Integer integer : nums2) {
            min.insert(integer);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = min.poll();
        }
        System.out.println(isSorted(nums2));
        s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) + "ms");

        System.out.println(isSame(nums1, nums2));
    }

    private static boolean isSorted(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    private static boolean isSame(Integer[] nums1, Integer[] nums2) {
        int len = nums1.length;
        if (len != nums2.length) return false;
        for (int i = 0; i < len; i++) {
            if (!nums1[i].equals(nums2[i])) return false;
        }
        return true;
    }
}
