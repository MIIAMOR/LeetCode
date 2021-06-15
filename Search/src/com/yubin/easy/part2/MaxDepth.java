package com.yubin.easy.part2;

import com.yubin.Node;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
    private int maxDep;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        maxDep = 0;
        dfs(root, 0);
        return maxDep;
    }

    /**
     * 深度优先搜索 dfs
     */
    private void dfs(Node n, int depth) {
        maxDep = Math.max(maxDep, depth);
        if (n == null || n.children == null) return;
        for (Node child : n.children) {
            dfs(child, depth + 1);
        }
    }

    /**
     * 广度优先搜索 bfs
     */
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        Deque<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.addLast(root);
        while (true) {
            int count = 0;//记录为不null的下一层次的节点数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.removeFirst();
                if (n == null) continue;
                if (n.children != null) {
                    for (Node child : n.children) {
                        if (child != null) count++;
                        queue.addLast(child);
                    }
                }
            }
            depth++;
            if (count == 0) return depth;
        }
    }
}
