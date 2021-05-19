package com.yubin.basic;

import java.util.Comparator;
import java.util.Random;

/**
 * 基础类
 */
public class Sort {

    /**
     * 交换索引i和j位置的元素
     *
     * @param ele
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] ele, int i, int j) {
        Comparable c = ele[i];
        ele[i] = ele[j];
        ele[j] = c;
    }

    private static void exch(Object[] ele, int i, int j) {
        Object c = ele[i];
        ele[i] = ele[j];
        ele[j] = c;
    }

    /**
     * 归并排序板块
     * ---------------------------------------------------------------------------------------------------------------------------
     */

    public static void mergeSort(Comparable[] ele) {
        mergeSort(ele, 0, ele.length - 1);
    }

    public static void mergeSort(Object[] ele, Comparator comparator) {
        mergeSort(ele, 0, ele.length - 1, comparator);
    }

    public static void mergeSort(Object[] ele, int left, int right, Comparator comparator) {
        if (left >= right) return;
        int mid = (right - left) / 2 + left;
        mergeSort(ele, left, mid, comparator);
        mergeSort(ele, mid + 1, right, comparator);
        merge(ele, left, mid, right, comparator);
    }

    public static void mergeSort(Comparable[] ele, int left, int right) {
        if (left >= right) return;
        int mid = (right - left) / 2 + left;
        mergeSort(ele, left, mid);
        mergeSort(ele, mid + 1, right);
        merge(ele, left, mid, right);
    }

    /**
     * @param ele
     * @param left
     * @param mid        这里的mid包含在左侧
     * @param right
     * @param comparator
     */
    private static void merge(Object[] ele, int left, int mid, int right, Comparator comparator) {
        Object[] temp = new Object[right - left + 1];
        int leftI = left, rightI = mid + 1, index = 0;
        while (leftI <= mid && rightI <= right)
            temp[index++] = comparator.compare(ele[leftI], ele[rightI]) < 0 ? ele[leftI++] : ele[rightI++];
        while (leftI <= mid)
            temp[index++] = ele[leftI++];
        while (rightI <= right)
            temp[index++] = ele[rightI++];
        for (int i = 0; i < temp.length; i++) {
            ele[i + left] = temp[i];
        }
    }

    private static void merge(Comparable[] ele, int left, int mid, int right) {
        Comparable[] temp = new Comparable[right - left + 1];
        int leftI = left, rightI = mid + 1, index = 0;
        while (leftI <= mid && rightI <= right)
            temp[index++] = ele[leftI].compareTo(ele[rightI]) < 0 ? ele[leftI++] : ele[rightI++];
        while (leftI <= mid)
            temp[index++] = ele[leftI++];
        while (rightI <= right)
            temp[index++] = ele[rightI++];
        for (int i = 0; i < temp.length; i++) {
            ele[i + left] = temp[i];
        }
    }

    /**
     * 快速排序板块
     * ---------------------------------------------------------------------------------------------------------------------------
     */

    public static void quickSort(Object[] ele, Comparator comparator) {
        quickSort(ele, 0, ele.length - 1, comparator);
    }

    public static void quickSort(Comparable[] ele) {
        quickSort(ele, 0, ele.length - 1);
    }

    /**
     * 合并分支
     *
     * @param ele
     * @param left
     * @param right
     * @param comparator
     */
    public static void quickSort(Object[] ele, int left, int right, Comparator comparator) {
        if (left >= right) return;
        int mid = partition(ele, left, right, comparator);
        quickSort(ele, left, mid - 1, comparator);
        quickSort(ele, mid + 1, right, comparator);
    }

    public static void quickSort(Comparable[] ele, int left, int right) {
        if (left >= right) return;
        int mid = partition(ele, left, right);
        quickSort(ele, left, mid - 1);
        quickSort(ele, mid + 1, right);
    }

    /**
     * 划分有序段
     *
     * @param ele
     * @param left
     * @param right
     * @param comparator
     * @return
     */
    private static int partition(Object[] ele, int left, int right, Comparator comparator) {
        //随机获取一个点作为坐标点
        int flag = new Random().nextInt(right - left + 1) + left;
        int keyIndex = left;
        exch(ele, flag, right);
        for (int i = left; i < right; i++) {
            if (comparator.compare(ele[i], ele[right]) >= 0)
                continue;
            exch(ele, keyIndex, i);
            keyIndex++;
        }
        exch(ele, keyIndex, right);
        return keyIndex;
    }

    private static int partition(Comparable[] ele, int left, int right) {
        //随机获取一个点作为坐标点
        int flag = new Random().nextInt(right - left + 1) + left;
        int keyIndex = left;
        exch(ele, flag, right);
        for (int i = left; i < right; i++) {
            if (ele[i].compareTo(ele[right]) >= 0)
                continue;
            exch(ele, keyIndex, i);
            keyIndex++;
        }
        exch(ele, keyIndex, right);
        return keyIndex;
    }
}