package com.yubin.part03;

import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/6/26 11:06
 * easy
 */
public class MyQueue {
    /**
     * 基于链表实现的队列
     */
    private final Node head;
    private final Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (head.next == null) {
            head.next = new Node(x);
            tail.next = head.next;
        } else {
            tail.next.next = new Node(x);
            tail.next = tail.next.next;
        }
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (head.next == null) return Integer.MAX_VALUE;
        int val = head.next.val;
        head.next = head.next.next;
        if (head.next == null) tail.next = null;
        size--;
        return val;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (head.next == null) return Integer.MAX_VALUE;
        return head.next.val;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.pop());
        System.out.println(q.peek());
    }
}

class MyQueue2 {
    /**
     * 基于数组实现的队列
     */
    private int[] val;
    private int head, tail, size;
    private int capacity = 15;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        size = 0;
        head = 0;
        tail = 0;
        val = new int[capacity];
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        tail = (tail + 1) % capacity;
        if (tail == head) resize();
        val[tail] = x;
        size++;
    }

    private void resize() {
        int[] newVal = new int[capacity * 2];
        for (int i = 1; i < capacity; i++) {
            newVal[i] = val[(++head) % capacity];
        }
        val = newVal;
        head = 0;
        tail = capacity;
        capacity = 2 * capacity;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        size--;
        head = (head + 1) % capacity;
        return val[head];
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return val[(head + 1) % capacity];
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * 利用双栈实现队列
 */
class MyQueue3 {
    private final LinkedList<Integer> inStack;
    private final LinkedList<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue3() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        inToOut();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        inToOut();
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void inToOut() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
    }
}
