package com.yubin.part2;

public class CanPlaceFlowers {
    /**
     * 贪心规则，只要有空位我就种花
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) return n == 0 || (n == 1 && flowerbed[0] == 0);
        int num = 0;//代表我已经种花的数量
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;//由于i处已经种植了，所以后面的位置不能种植，跳过
                continue;
            }
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    num++;
                }
                i++;
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    num++;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    num++;
                    i++;
                }
            }
        }
        return num >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(cpf.canPlaceFlowers(flowerbed, n));
    }
}
