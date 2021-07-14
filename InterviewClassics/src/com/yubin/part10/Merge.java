package com.yubin.part10;

/**
 * @author MIIAMOR
 * @date 2021/7/2 13:30
 */
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] T = new int[m];
        System.arraycopy(A, 0, T, 0, m);
        int index = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (T[i] < B[j]) A[index++] = T[i++];
            else A[index++] = B[j++];
        }
        while (i < m) A[index++] = T[i++];
        while (j < n) A[index++] = B[j++];
    }
}
