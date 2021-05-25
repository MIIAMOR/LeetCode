package com.yubin.easy.part1;

import java.util.*;

public class TwoSum2 {
    /**
     * 双指针解法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[][] numbers = new int[nums.length][2];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i][0] = nums[i];
            numbers[i][1] = i;
        }
        Arrays.sort(numbers, (n1, n2) -> n1[0] - n2[0]);
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            //相加结果大于target，则需要更小的数作为加数，right--
            //相加结果小于target，则需要更大的数作为加数，left++
            if (numbers[left][0] + numbers[right][0] > target) right--;
            else if (numbers[left][0] + numbers[right][0] < target) left++;
            else {
                res[0] = numbers[left][1];
                res[1] = numbers[right][1];
                return res;
            }
        }
        return null;
    }

    /**
     * 哈希映射法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();
        int[] nums = new int[]{1, 2, 7, 11};
        int target = 9;
        for (int i : ts.twoSum1(nums, target)) {
            System.out.println(i);
        }
    }
}
