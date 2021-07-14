package com.yubin.medium.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MIIAMOR
 * @date 2021/7/5 20:55
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int right = nums.length - 1;
            for (int left = i + 1; left < nums.length; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) continue;
                while (left < right && nums[i] + nums[left] + nums[right] > 0) right--;
                if (left == right) break;
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
