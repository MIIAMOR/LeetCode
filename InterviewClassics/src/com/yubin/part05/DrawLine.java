package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/29 12:38
 */
public class DrawLine {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];// 结果
        int wNum = w / 32;
        int x1Pos = x1 / 32 + y * wNum, x2Pos = x2 / 32 + y * wNum;// x1和x2两个点所在的索引
        // 边界处理
        if (x1Pos != x2Pos) {
            for (int i = 0; i < 32 - x1 % 32; i++) {
                res[x1Pos] |= (1 << i);
            }
            for (int i = 0; i <= x2 % 32; i++) {
                res[x2Pos] += (1 << 32 - i - 1);
            }
        } else {
            for (int i = 31 - x2 % 32; i <= 31 - x1 % 32; i++) {
                res[x1Pos] |= (1 << i);
            }
        }
        // 中间部分处理
        for (int i = x1Pos + 1; i < x2Pos; i++) {
            res[i] = -1;
        }
        return res;
    }
}
