package com.yubin.part1;

import java.util.Arrays;

public class FindContentChildren {
    /**
     * 贪心算法求解，优先满足胃口小的孩子，并且让胃口小的孩子先吃到饼干，并且饼干尽可能小
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindContentChildren fcc = new FindContentChildren();
        int[] g1 = new int[]{1, 2, 3};
        int[] s1 = new int[]{1, 1};
        System.out.println(fcc.findContentChildren(g1, s1));
        int[] g2 = new int[]{1, 2};
        int[] s2 = new int[]{1, 2, 3};
        System.out.println(fcc.findContentChildren(g2, s2));
    }
}
