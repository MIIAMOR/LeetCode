package com.yubin.part10;

/**
 * @author MIIAMOR
 * @date 2021/7/3 21:16
 */
public class Search {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            if (arr[left] == target) return left;
            mid = (right + left) / 2;
            if (arr[mid] == target) right = mid;
            else if (arr[0] < arr[mid]) {
                if (arr[0] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else if (arr[0] > arr[mid]) {
                if (arr[mid] < target && target <= arr[arr.length - 1]) left = mid + 1;
                else right = mid - 1;
            } else left++;
        }
        return -1;
    }

    public int search1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
