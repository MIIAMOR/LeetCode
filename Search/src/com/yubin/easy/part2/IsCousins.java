package com.yubin.easy.part2;

import com.yubin.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (true) {
            int size = queue.size();
            boolean xIn = false, yIn = false;
            for (int i = 0; i < size; i++) {
                boolean flag = false;
                TreeNode tree = queue.removeFirst();
                if (tree.left != null) {
                    queue.addLast(tree.left);
                    if (tree.left.val == x) {
                        xIn = true;
                        flag = true;
                    }
                    if (tree.left.val == y) {
                        yIn = true;
                        flag = true;
                    }
                }
                if (tree.right != null && !flag) {
                    queue.addLast(tree.right);
                    if (tree.right.val == x) xIn = true;
                    if (tree.right.val == y) yIn = true;
                }
                if (xIn && yIn) return true;
            }
            if (xIn || yIn) return false;
        }
    }
}
