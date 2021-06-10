package com.yubin.medium.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopKFrequent {
    /**
     * 对每个数字的频率计数，然后排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<Count> counts = new ArrayList<>();
        counts.add(new Count(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                counts.add(new Count(nums[i]));
                continue;
            }
            counts.get(counts.size() - 1).count++;
        }
        Collections.sort(counts);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = counts.get(i).num;
        }
        return res;
    }

    class Count implements Comparable {
        public int num;
        public int count = 1;

        public Count(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Object o) {
            Count c = (Count) o;
            return c.count - this.count;
        }
    }
}
