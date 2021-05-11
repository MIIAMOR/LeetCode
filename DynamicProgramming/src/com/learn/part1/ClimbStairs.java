package com.learn.part1;

public class ClimbStairs {
    /**
     * 由于爬楼梯的方式要么两格一步，要么一格一步<br>
     * 所以爬到最后一阶楼梯的时候要么跨出两步，要么跨出一步<br>
     * 所以F(n)=F(n-1)+F(n-2)
     *
     * @param n 楼梯数
     * @return 爬楼梯的方式数
     */
    public int climbStairs(int n) {
        int pre = 1, curr = 2, res = 1;
        for (int i = 1; i < n; i++) {
            res = curr;
            curr = pre + curr;
            pre = res;
        }
        return res;
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(4));
    }
}
