package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/6/23 10:46
 */
public class TrailingZeroes {
    /**
     * 尾数0只取决于阶乘结果质因数分解后2和5的个数
     */
    public int trailingZeroes1(int n) {
        int count = 0;
        for (int i = 0; i <= n; i += 5) {
            int five = i;
            while (five > 0 && five % 5 == 0) {
                five /= 5;
                count++;
            }
        }
        return count;
    }

    /**
     * 由于尾数0的个数只取决于阶乘结果质因数分解后2和5的个数
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 1) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        int count = 0, currentMultiple = 5;
        while (n >= currentMultiple) {
            // 这里的n / currentMultiple表示的是1..n中可以被分解为currentMultiple的个数
            // currentMultiple最开始为5
            // 每一轮过后 currentMultiple *= 5
            count += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(3000));
        System.out.println(new TrailingZeroes().trailingZeroes1(3000));
        System.out.println(new TrailingZeroes().trailingZeroes2(3000));
    }
}
