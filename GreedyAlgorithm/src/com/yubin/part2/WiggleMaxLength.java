package com.yubin.part2;

public class WiggleMaxLength {
    /**
     * 动态规划算法加暴力枚举
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength1(int[] nums) {
        //分别表示以以nums[i]结尾的最长序列长度以及下一个数扩展时是选择比当前的数大还是小
        int len = nums.length;
        int[] dp = new int[len];
        int[] flag = new int[len];//-1-小的数扩展 1-大的数扩展 0-无所谓
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] > j) break;
                if (dp[j] > dp[i]) {
                    switch (flag[j]) {
                        case 0 -> {
                            if (nums[i] - nums[j] > 0)
                                flag[i] = -1;
                            else if (nums[i] - nums[j] < 0)
                                flag[i] = 1;
                        }
                        case -1 -> {
                            if (nums[i] - nums[j] < 0)
                                flag[i] = 1;
                        }
                        case 1 -> {
                            if (nums[i] - nums[j] > 0)
                                flag[i] = -1;
                        }
                    }
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int wiggleMaxLength2(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }

    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prediff = nums[1] - nums[0];
        int ans = (nums[1] != nums[0]) ? 2 : 1;

        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((prediff >= 0 && diff < 0) || (prediff <= 0 && diff > 0)) {
                ans++;
                prediff = diff;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        WiggleMaxLength wm = new WiggleMaxLength();
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};
        System.out.println(wm.wiggleMaxLength1(nums));
        System.out.println(wm.wiggleMaxLength2(nums));
        System.out.println(wm.wiggleMaxLength3(nums));
    }
}
