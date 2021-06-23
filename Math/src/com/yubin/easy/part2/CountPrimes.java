package com.yubin.easy.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/23 15:06
 */
public class CountPrimes {
    /**
     * 埃拉托斯特尼筛选法
     * 当然这里还可以继续优化，对于一个质数 xx，如果按上文说的我们从 2x2x 开始标记其实是冗余的，
     * 应该直接从 x*x 开始标记，因为 2x,3x,这些数一定在 xx 之前就被其他数的倍数标记过了，例如 2的所有倍数，3的所有倍数等
     */
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int count = 0;
        int[] numbers = new int[n];
        for (int i = 2; i < n; i++) {
            if (numbers[i] == -1) continue;
            count++;
            if (((long) i * i) < n) {
                for (int j = i * i; j > 0 && j < n; j += i) {
                    numbers[j] = -1;
                }
            }
        }
        return count;
    }

    /**
     * 线性筛选
     */
    public int countPrimes1(int n) {
        if (n == 0 || n == 1) return 0;
        List<Integer> primes = new ArrayList<>();
        int[] numbers = new int[n];
        for (int i = 2; i < n; i++) {
            if (numbers[i] == 0)
                primes.add(i);
            for (int j = 0; j < primes.size() && primes.get(j) * i < n; j++) {
                numbers[primes.get(j) * i] = -1;
                if (i % primes.get(j) == 0) break;
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(499979));
        System.out.println(new CountPrimes().countPrimes1(499979));
    }
}
