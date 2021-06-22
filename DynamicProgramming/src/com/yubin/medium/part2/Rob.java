package com.yubin.medium.part2;

public class Rob {
    /**
     * 限制：不可以同时访问相邻的两个数
     * 思路：每家都可以选择偷或者不偷，如果偷第i家，那么当前最大的值就是i-2家前所得的最大值加上i家
     *
     * @param nums 每家中存在的现金数量
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        // 分别表示偷这家 或者 放过这家 这两种情况已经偷盗的最大值
        int[] steal = new int[len];
        int[] leave = new int[len];
        steal[0] = nums[0];
        steal[1] = nums[1];
        leave[0] = 0;
        leave[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            // 如果选择放过这家  则可以获取的最大值就是 steal[i-1]或者leave[i-1]
            leave[i] = Math.max(steal[i - 1], leave[i - 1]);
            // 如果选择偷盗这家  则可以获取的最大值就是 leave[i-1]和steal[i-2]中的最大值加上nums[i]
            steal[i] = Math.max(leave[i - 1], steal[i - 2]) + nums[i];
        }
        return Math.max(steal[len - 1], leave[len - 1]);
    }

    /**
     * 空间优化，每次只用了三个数来递推求解
     */
    public int rob1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int steal2 = nums[0], steal1 = nums[1], leave1 = nums[0];
        int leave = nums[0], steal = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            leave = Math.max(leave1, steal1);
            steal = Math.max(leave1, steal2) + nums[i];
            leave1 = leave;
            steal2 = steal1;
            steal1 = steal;
        }
        return Math.max(leave, steal);
    }

    public void test() {
        System.out.println(rob1(new int[]{1, 2, 3, 1}));
    }

    public static void main(String[] args) {
        new Rob().test();
    }
}
