package com.yubin.week247;

/**
 * @author MIIAMOR
 * @date 2021/6/27 11:36
 * 未做
 */
public class WonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        char[] chars = word.toCharArray();
        int[] count = new int[1024];
        count[0] = 1;
        long res = 0L;
        int pre = 0;
        for (char c : chars) {
            pre ^= (1 << (c - 'a'));
            res += count[pre];
            for (int i = 0; i < 10; i++) {
                res += count[pre ^ (1 << i)];
            }
            count[pre]++;
        }
        return res;
    }
}
