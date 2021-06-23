package com.yubin.easy.part2;

/**
 * @author MIIAMOR
 * @date 2021/6/23 10:42
 */
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        char[] columnCount = columnTitle.toCharArray();
        int res = 0, base = 1;
        for (int i = columnCount.length - 1; i >= 0; i--) {
            res += (columnCount[i] - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("ZY"));
    }
}
