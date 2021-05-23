package com.yubin.medium.part1;

public class CanCompleteCircuit {
    /**
     * 解题就是要暴力
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] - cost[i] < 0) continue;
            int remainGas = 0;
            for (int j = 0; j < len; j++) {
                int index = j + i >= len ? j + i - len : j + i;
                remainGas += (gas[index] - cost[index]);
                if (remainGas < 0) break;
            }
            if (remainGas >= 0) return i;
        }
        return -1;
    }

    /**
     * 解法参考
     * https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int remainGas = 0, minGas = 0, index = 0;
        for (int i = 0; i < len; i++) {
            remainGas += (gas[i] - cost[i]);
            if (minGas > remainGas) {
                index = i + 1;
                minGas = remainGas;
            }
        }
        remainGas = 0;
        for (int i = 0; i < len; i++) {
            int ii = i + index >= len ? i + index - len : i + index;
            remainGas += gas[ii] - cost[ii];
            if (remainGas < 0) break;
        }
        if (remainGas >= 0) return index;
        return -1;
    }


    public static void main(String[] args) {
        CanCompleteCircuit ccc = new CanCompleteCircuit();
        int[] gas1 = new int[]{1, 2, 3, 4, 5};
        int[] cost1 = new int[]{3, 4, 5, 1, 2};
        System.out.println(ccc.canCompleteCircuit1(gas1, cost1));
        System.out.println(ccc.canCompleteCircuit2(gas1, cost1));
        int[] gas2 = new int[]{2, 3, 4};
        int[] cost2 = new int[]{3, 4, 3};
        System.out.println(ccc.canCompleteCircuit1(gas2, cost2));
    }
}
