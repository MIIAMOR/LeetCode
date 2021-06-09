package com.yubin.easy.part2;

import java.util.*;

public class RelativeSortArray {
    /**
     * TreeMap求解
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i : arr1) {
            if (count.containsKey(i)) {
                int n = count.get(i);
                count.put(i, ++n);
            } else count.put(i, 1);
        }
        int index = 0;
        for (int i : arr2) {
            int n = count.get(i);
            count.remove(i);
            for (int j = 0; j < n; j++) {
                res[index++] = i;
            }
        }
        Set<Integer> set = count.keySet();
        for (Integer i : set) {
            int n = count.get(i);
            for (int j = 0; j < n; j++) {
                res[index++] = i;
            }
        }
        return res;
    }

    /**
     * 自定义排序
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> point = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            point.put(arr2[i], i);
        }
        sort(arr1, 0, arr1.length - 1, point);
        return arr1;
    }

    private void sort(int[] arr, int left, int right, Map<Integer, Integer> point) {
        if (left > right) return;
        int mid = partition(arr, left, right, point);
        sort(arr, left, mid - 1, point);
        sort(arr, mid + 1, right, point);
    }

    private void exch(int[] ele, int i, int j) {
        int n = ele[i];
        ele[i] = ele[j];
        ele[j] = n;
    }

    private int partition(int[] ele, int left, int right, Map<Integer, Integer> point) {
        int index = left;
        for (int i = left; i < right; i++) {
            if (less(ele[i], ele[right], point)) {
                exch(ele, i, index++);
            }
        }
        exch(ele, index, right);
        return index;
    }

    private boolean less(int i, int j, Map<Integer, Integer> point) {
        if (point.containsKey(i) && point.containsKey(j)) return point.get(i) < point.get(j);
        else if (point.containsKey(i)) return true;
        else if (point.containsKey(j)) return false;
        else return i < j;
    }

    public void test() {
        for (int i : relativeSortArray(new int[]{1, 1, 2, 3, 2, 4, 0}, new int[]{3, 2, 1})) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : relativeSortArray1(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new RelativeSortArray().test();
    }
}
