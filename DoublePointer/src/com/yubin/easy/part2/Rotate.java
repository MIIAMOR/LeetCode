package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/7/4 14:54
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] tmp = new int[len];
        System.arraycopy(nums, 0, tmp, 0, len);
        for (int i = 0; i < len; i++) {
            nums[(k + i) % len] = tmp[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int count = gcd(len, k);
        for (int i = 0; i < count; i++) {
            int num, nextPoint = i, nextNum = nums[nextPoint];
            do {
                num = nextNum;
                nextPoint = (nextPoint + k) % len;
                nextNum = nums[nextPoint];
                nums[nextPoint] = num;
            } while (nextPoint != i);
        }
    }

    private int gcd(int n, int k) {
        return k > 0 ? gcd(k, n % k) : n;
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }
}
