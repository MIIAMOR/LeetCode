package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/22
 */
public class Reverse {
    /**
     * 余数相加
     */
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int base;
        long res = 0;
        while (x >= 1) {
            res *= 10;
            base = x % 10;
            res += base;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE) return 0;
        return (int) (sign * res);
    }

    /**
     * 字符串解析方法求解
     */
    public int reverse1(int x) {
        String num = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = num.length() - 1; i > 0; i--) {
            char c = num.charAt(i);
            if (i == num.length() - 1 && c != '0') flag = false;
            if (c == '0' && flag) {
                flag = false;
                continue;
            }
            sb.append(c);
        }
        long res;
        if (x < 0) res = -1 * Long.parseLong(sb.toString());
        else {
            sb.append(num.charAt(0));
            res = Long.parseLong(sb.toString());
        }
        if (Math.abs(res) > Integer.MAX_VALUE) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(364600900));
    }
}
