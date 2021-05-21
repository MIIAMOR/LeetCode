package com.yubin.part1;

public class MaxArea {
    /**
     * 暴力枚举法
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height.length == 1) return 0;
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                res = Math.max(res, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    /**
     * 我是傻子:双指针解法
     * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height.length <= 1) return 0;
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int newRes = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            res = res > newRes ? res : newRes;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height1 = new int[]{1, 3, 2, 5, 25, 24, 5};
        System.out.println(ma.maxArea1(height));
        System.out.println(ma.maxArea2(height1));
    }
}
