package com.yubin.part08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/6/30 11:28
 */
public class Hanota {
    /**
     * A为起点，B为缓冲区，C为终点
     * 1：把A上面的n-1个盘子利用C移动到B上
     * 2：把A剩余的盘子移动到C上
     * 3：把B上面的n-1个盘子以相同的方式以A为缓冲区移动到C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 作弊试一试
        // C.addAll(A);
        // A.clear();
        int len = A.size();
        move(len - 1, A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 0) {
            C.add(A.remove(A.size() - 1));
        } else {
            move(n - 1, A, C, B);
            move(0, A, B, C);
            move(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }

    private static void move(int n, char A, char B, char C) {
        if (n == 1) System.out.println(A + " --> " + C);
        else {
            move(n - 1, A, C, B);
            move(1, A, B, C);
            move(n - 1, B, A, C);
        }
    }
}
