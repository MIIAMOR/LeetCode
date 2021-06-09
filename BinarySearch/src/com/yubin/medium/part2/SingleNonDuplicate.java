package com.yubin.medium.part2;

public class SingleNonDuplicate {
    /**
     * 暴力枚举法
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i + 1]) continue;
            return nums[i];
        }
        return nums[nums.length - 1];
    }

    /**
     * 二分查找算法
     * 判断当前的下标是奇数还是偶数，然后判断他的左右側
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            //确保判断的时候，数组不会越界
            if (mid + 1 < nums.length && mid - 1 >= 0) {
                if (mid % 2 == 0) {
                    //当前的下标是偶数
                    if (nums[mid] == nums[mid + 1]) {
                        //说明单独出现的数在右侧
                        left = mid + 1;
                    } else if (nums[mid] == nums[mid - 1]) {
                        //说明单独出现的数在左侧
                        right = mid - 1;
                    } else return nums[mid];
                } else {
                    //当前的下标是奇数
                    if (nums[mid] == nums[mid - 1]) {
                        //说明单独出现的数在右侧
                        left = mid + 1;
                    } else if (nums[mid] == nums[mid + 1]) {
                        //说明单独出现的数在左侧
                        right = mid - 1;
                    } else return nums[mid];
                }
            } else return nums[mid];
        }
        return 0;
    }

    public void test() {
        System.out.println(singleNonDuplicate1(new int[]{1, 1, 2, 2, 3, 3, 4}));
    }

    public static void main(String[] args) {
        new SingleNonDuplicate().test();
    }
}
