package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 22:30
 */
public class ConvertInteger {
    public int convertInteger(int A, int B) {
        int countDif = A ^ B;// AB中的不同为在count中为1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((countDif & (1 << i)) == (1 << i))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new ConvertInteger().convertInteger(29, 15);
    }
}
