package com.yubin.easy.part1;

public class TwoSum {
    /**
     * 双指针解法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            //相加结果大于target，则需要更小的数作为加数，right--
            //相加结果小于target，则需要更大的数作为加数，left++
            if (numbers[left] + numbers[right] > target) right--;
            else if (numbers[left] + numbers[right] < target) left++;
            else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{1, 2, 7, 11};
        int target = 9;
        for (int i : ts.twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}
