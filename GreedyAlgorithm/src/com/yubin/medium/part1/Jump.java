package com.yubin.medium.part1;

public class Jump {
    /**
     * 判断最短步数到达最后一个点<br>
     * 首先确定当前点A能到达得最远的点B，然后<br>
     * 再在这两点之间，寻找第二步，要求第二步达到的点最远<br>
     * 且起始位置需要是AB之间<br>
     * 依次类推，直到确定到最后一个点的步数
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int res = 1, curr = 0;
        int left = 0, right = nums[0] + 0;
        while (true) {
            if (right >= nums.length - 1) return res;
            for (int i = left; i <= right; i++) {
                curr = Math.max(i + nums[i], curr);
            }
            res++;
            left = right;
            right = curr;
        }
    }

    public static void main(String[] args) {
        Jump j = new Jump();
        int[] nums1 = new int[]{3, 2, 1, 1, 4};
        int[] nums2 = new int[]{2, 3, 0, 1, 4};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{2, 0, 0};
        System.out.println(j.jump(nums1));
        System.out.println(j.jump(nums2));
        System.out.println(j.jump(nums3));
        System.out.println(j.jump(nums4));
    }
}
