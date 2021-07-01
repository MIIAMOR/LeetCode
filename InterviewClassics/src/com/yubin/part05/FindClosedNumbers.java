package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 22:25
 */
public class FindClosedNumbers {
    public int[] findClosedNumbers(int num) {
//        return findClosedNumbers1(num);
        return findClosedNumbers2(num);
    }

    /**
     * 暴力枚举
     */
    public int[] findClosedNumbers1(int num) {
        if (num <= 0 || num >= Integer.MAX_VALUE) return new int[]{-1, -1};
        int count = countOnes(num);
        int big = num + 1, small = num - 1;
        while (big < Integer.MAX_VALUE && countOnes(big) != count)
            big++;
        while (small > 0 && countOnes(small) != count)
            small--;
        big = big == Integer.MAX_VALUE ? -1 : big;
        small = small == 0 ? -1 : small;
        return new int[]{big, small};
    }

    private int countOnes(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) count++;
        }
        return count;
    }

    /**
     * 比 num 大的数：从右往左，找到第一个 01 位置，然后把 01 转为 10，右侧剩下的 1 移到右侧的低位，右侧剩下的位清0。
     * 比 num 小的数：从右往左，找到第一个 10 位置，然后把 10 转为 01，右侧剩下的 1 移到右侧的高位，右侧剩下的位置0。
     * <p>
     * 常规上，低位在右侧，bitset 注意方向相反
     * https://leetcode-cn.com/problems/closed-number-lcci/solution/wei-yun-suan-by-wushaoling-2/
     */
    public int[] findClosedNumbers2(int num) {
        int count = 0;// 记录1的数量
        int big = -1, small = -1;
        int numTmp = num;
        for (int i = 0; i < 30; i++) {
            // 遇到01，把他变为10，并且把右侧的1放到最右边
            if ((num & (1 << i)) != 0 && (num & (1 << i + 1)) == 0) {
                numTmp += (1 << i + 1);
                numTmp -= (1 << i);
                for (int j = 0; j < count; j++) {
                    numTmp += (1 << j);
                }
                big = numTmp;
                break;
            }
            if ((num & (1 << i)) != 0) count++;
            numTmp &= (~(1 << i));
        }
        numTmp = num;
        count = 0;
        for (int i = 0; i < 30; i++) {
            // 遇到10，把他变为01，并且把右侧的1放到最右边
            if ((num & (1 << i)) == 0 && (num & (1 << i + 1)) != 0) {
                numTmp -= (1 << i + 1);
                numTmp += (1 << i);
                for (int j = 0; j < count; j++) {
                    numTmp += (1 << i - j - 1);
                }
                small = numTmp;
                break;
            }
            if ((num & (1 << i)) != 0) count++;
            numTmp &= (~(1 << i));
        }
        return new int[]{big, small};
    }

    public static void main(String[] args) {
        new FindClosedNumbers().findClosedNumbers(67);
    }
}
