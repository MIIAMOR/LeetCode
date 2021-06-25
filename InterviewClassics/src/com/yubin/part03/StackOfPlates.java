package com.yubin.part03;

/**
 * @author MIIAMOR
 * @date 2021/6/25 19:20
 * medium
 */
public class StackOfPlates {
    private final Node stackHead;
    private Node stackPointer;
    private final int cap;
    private int length;

    public StackOfPlates(int cap) {
        this.cap = cap;
        stackHead = new Node(null);
        stackPointer = stackHead;
        this.length = 0;
    }

    public void push(int val) {
        if (cap == 0) return;
        if (stackPointer.size == cap || stackPointer == stackHead) {
            stackPointer.next = new Node(new int[cap], stackPointer);
            stackPointer = stackPointer.next;
            this.length++;
        }
        stackPointer.val[stackPointer.size++] = val;
    }

    public int pop() {
        if (stackPointer == stackHead) return -1;
        int res = stackPointer.val[--stackPointer.size];
        if (stackPointer.size == 0) {
            stackPointer = stackPointer.pre;
            stackPointer.next = null;
            this.length--;
        }
        return res;
    }

    public int popAt(int index) {
        if (index >= length) return -1;
        if (index == length - 1) return pop();
        Node node = stackHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        int res = node.val[--node.size];
        if (node.size == 0) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            this.length--;
        }
        return res;
    }

    static class Node {
        int size = 0;
        int[] val;
        Node pre;
        Node next;

        public Node(int[] val) {
            this.val = val;
        }

        public Node(int[] val, Node pre) {
            this.val = val;
            this.pre = pre;
        }
    }
}
