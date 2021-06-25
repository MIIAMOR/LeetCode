package com.yubin.part03;

/**
 * @author MIIAMOR
 * @date 2021/6/25 17:37
 * easy
 */
public class MinStack {
    /**
     * 辅助栈存储当前的最小元素
     */
    private Node stackHead = null;
    private Node stackPointer = null, stackMinPointer = null;

    public MinStack() {
        stackHead = new Node(Integer.MAX_VALUE);
        stackPointer = stackHead;
        stackMinPointer = new Node(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stackPointer.next = new Node(x, stackPointer);
        stackMinPointer.next = new Node(Math.min(stackMinPointer.val, x), stackMinPointer);
        stackPointer = stackPointer.next;
        stackMinPointer = stackMinPointer.next;
    }

    public void pop() {
        if (stackPointer == stackHead) return;
        stackPointer = stackPointer.pre;
        stackPointer.next = null;
        stackMinPointer = stackMinPointer.pre;
        stackMinPointer.next = null;
    }

    public int top() {
        return stackPointer.val;
    }

    public int getMin() {
        return stackMinPointer.val;
    }

    private static class Node {
        public int val;
        public Node pre;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node pre) {
            this.val = val;
            this.pre = pre;
        }
    }
}
