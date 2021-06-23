package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/6/23 10:19
 */
public class ConvertToTitle {
    public String convertToTitle1(int columnNumber) {
        if (columnNumber >= 1 && columnNumber <= 26)
            return "" + (char) (columnNumber - 1 + 'A');
        if (columnNumber == 0) return "";
        int high = columnNumber / 26;
        int low = columnNumber % 26;
        if (low == 0) {
            low = 26;
            high--;
        }
        return convertToTitle1(high) + (char) (low - 1 + 'A');
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int high = columnNumber, low;
        while (high >= 1) {
            low = high % 26;
            high = high / 26;
            if (low == 0) {
                low = 26;
                high--;
            }
            sb.append((char) (low - 1 + 'A'));
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(701));
    }
}
