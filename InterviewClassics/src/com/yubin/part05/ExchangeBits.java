package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 23:40
 */
public class ExchangeBits {
    public int exchangeBits(int num) {
        for (int i = 0; i < 32; i += 2) {
            boolean test1 = test(num, i), test2 = test(num, i + 1);
            if (test1 == test2) continue;
            int base1 = 1 << i, base2 = 1 << (i + 1);
            if (test1) {
                num -= base1;
                num += base2;
            } else {
                num += base1;
                num -= base2;
            }
        }
        return num;
    }

    private boolean test(int num, int base) {
        return (num & (1 << base)) != 0;
    }
}
