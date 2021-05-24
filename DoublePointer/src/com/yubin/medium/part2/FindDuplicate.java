package com.yubin.medium.part2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    /**
     * 环链想法<br>
     * 把数组的值当做节点类中的值以及下一个节点的地址，对应在数组中就是数组的index
     * 解法思路：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);
        //此时已经在环中相遇
        fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }

    /**
     * 排序后再找，时间复杂度ba行
     *
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }

    /**
     * 哈希表映射
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) return num;
            visited.add(num);
        }
        return 0;
    }

    /**
     * 建立数组副本
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int[] numsCopy = new int[nums.length];
        for (int num : nums) {
            if (numsCopy[num] == num) return num;
            numsCopy[num] = num;
        }
        return 0;
    }

    private void test() {
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public static void main(String[] args) {
        new FindDuplicate().test();
    }
}
