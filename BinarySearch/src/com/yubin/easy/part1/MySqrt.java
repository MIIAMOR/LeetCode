package com.yubin.easy.part1;

public class MySqrt {
    /**
     * 直接调用API
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 二分查找解法
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        else if (x == 1) return 1;
        int left = 1, right = x, mid = (x - 1) / 2 + 1;
        while (right - left > 1) {
            if ((long) mid * mid > x) {
                right = mid;
                mid = (right - left) / 2 + left;
            } else if ((long) mid * mid < x) {
                left = mid;
                mid = (right - left) / 2 + left;
            } else return mid;
        }
        return left;
    }


    private void test() {
        System.out.println(mySqrt1(2147395599));
        System.out.println(mySqrt(2147395599));
    }

    public static void main(String[] args) {
        new MySqrt().test();
    }
}
