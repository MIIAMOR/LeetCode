package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 14:41
 */
public class ReverseBits {
    /**
     * 模拟所有0都变成1的情况
     */
    public int reverseBits(int num) {
        // 最终结果 上一个0的位置(索引从0开始，lastZero默认为-1开始) 记录当前连续的1的长度
        int res = 0, lastZero = -1, curr = 0;
        for (int i = 0; i < 32; i++) {
            int bit = num & (1 << i);
            if (bit == 0) {
                // 如果遇到了0，那么假设把这个0变为1，则已知连续的1长度应该是这个0到上一个0的距离
                // curr在遇到0的时候会更新自己的长度
                curr = i - lastZero;
                // 由于每次只能让一个0变为1，因此在往后遍历的时候，需要把这个位置默认为0
                lastZero = i;
            } else {
                // 如果遇到了1，curr计数+1
                curr++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}