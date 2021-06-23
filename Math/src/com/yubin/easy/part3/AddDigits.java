package com.yubin.easy.part3;

/**
 * @author MIIAMOR
 * @date 2021/6/23 16:15
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num / 10 > 0) {
            int newNum = 0;
            while (num != 0) {
                newNum += (num % 10);
                num /= 10;
            }
            num = newNum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }
}
