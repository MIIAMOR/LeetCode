package com.yubin.part05;

/**
 * @author MIIAMOR
 * @date 2021/6/28 14:31
 */
public class PrintBin {
    /**
     * 十进制小数转二进制：乘基取整法
     */
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int count = 0;
        while (num != 0) {
            num *= 2;
            int head = (int) num;
            sb.append(head);
            num -= head;
            count++;
            if (count >= 30) return "ERROR";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PrintBin().printBin(0.625));
    }
}
