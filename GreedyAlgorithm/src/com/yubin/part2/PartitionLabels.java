package com.yubin.part2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    /**
     * 由于每一个段中出现的字符在其他地方不能出现第二次
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        //分别用于记录每个字母第一次和最后一次出现的位置
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int end = right[s.charAt(i) - 'a'];
            for (int j = i + 1; j <= end; j++) {
                end = Math.max(right[s.charAt(j) - 'a'], end);//重新记录遍历过程中新的最远点
            }
            list.add(end - i + 1);
            i = end;
        }
        return list;
    }

    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        List<Integer> list = pl.partitionLabels("ababcbacadefegdehijhklij");
        list.forEach(System.out::println);

    }
}
