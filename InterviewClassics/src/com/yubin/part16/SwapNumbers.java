package com.yubin.part16;

/**
 * @author MIIAMOR
 * @date 2021/7/13 16:34
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
