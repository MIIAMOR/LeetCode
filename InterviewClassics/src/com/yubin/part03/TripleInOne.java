package com.yubin.part03;

/**
 * @author MIIAMOR
 * @date 2021/6/25 17:18
 * easy
 */
public class TripleInOne {
    /**
     * 使用一个数组完成三个栈的模拟
     */
    int[][] stack = null;
    int stackSize = 0;

    public TripleInOne(int stackSize) {
        stack = new int[3][stackSize + 1];
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int index = stack[stackNum][stackSize];
        if (index == stackSize) return;
        stack[stackNum][index++] = value;
        stack[stackNum][stackSize] = index;
    }

    public int pop(int stackNum) {
        int index = stack[stackNum][stackSize];
        if (index == 0) return -1;
        stack[stackNum][stackSize] = --index;
        return stack[stackNum][index];
    }

    public int peek(int stackNum) {
        int index = stack[stackNum][stackSize];
        if (index == 0) return -1;
        return stack[stackNum][index - 1];
    }

    public boolean isEmpty(int stackNum) {
        int index = stack[stackNum][stackSize];
        return index == 0;
    }
}
