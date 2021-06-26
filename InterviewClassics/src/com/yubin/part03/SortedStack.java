package com.yubin.part03;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author MIIAMOR
 * @date 2021/6/26 13:26
 * medium
 */
public class SortedStack {
    private final Stack<Integer> data;
    private final Stack<Integer> help;

    public SortedStack() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int val) {
        if (data.isEmpty()) {
            data.push(val);
        } else {
            while (!data.isEmpty() && data.peek() < val) {
                help.push(data.pop());
            }
            data.push(val);
            while (!help.isEmpty()) {
                data.push(help.pop());
            }
        }
    }

    public void pop() {
        if (!isEmpty())
            data.pop();
    }

    public int peek() {
        if (!isEmpty())
            return data.peek();
        return -1;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

class SortedStack1 {
    private PriorityQueue<Integer> queue;

    public SortedStack1() {
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        queue.add(val);
    }

    public void pop() {
        if (!isEmpty())
            queue.poll();
    }

    public int peek() {
        if (!isEmpty())
            return queue.peek();
        return -1;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}