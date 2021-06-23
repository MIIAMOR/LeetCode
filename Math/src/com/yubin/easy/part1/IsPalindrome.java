package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/23 8:49
 */
public class IsPalindrome {
    /**
     * 回文数判断，当判断到中间位置的时候就可以比对结果了
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x, res = 0, count = 1;
        while (num >= 1) {
            res *= 10;
            res += (num % 10);
            num /= 10;
            if (num == res && res / count > 1) return true;
            if (res > num && res / count > 1) return res / 10 == num;
            count *= 10;
        }
        return res == x;
    }

    public static void main(String[] args) {
        new IsPalindrome().isPalindrome(131000);
    }
}
