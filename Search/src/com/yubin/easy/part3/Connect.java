package com.yubin.easy.part3;

import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/7/10 21:18
 */
public class Connect {
    /**
     * 对于完美二叉树有效 其所有叶子节点都在同一层，每个父节点都有两个子节点
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            // 由于数的特性，左不为空的时候，右边也一定不为空
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }


    /**
     * 对于一般二叉树也有效
     */
    public Node connect1(Node root) {
        if (root == null) return null;
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        while (true) {
            int size = q.size();
            if (size == 0) break;
            Node pre = q.getFirst();
            for (int i = 0; i < size; i++) {
                Node curr = q.removeFirst();
                if (curr.left != null) q.addLast(curr.left);
                if (curr.right != null) q.addLast(curr.right);
                if (pre == curr) continue;
                pre.next = curr;
                pre = curr;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
