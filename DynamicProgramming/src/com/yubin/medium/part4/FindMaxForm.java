package com.yubin.medium.part4;

/**
 * @author MIIAMOR
 * @date 2021/6/19
 */
public class FindMaxForm {
    /**
     * 向0-1背包问题转化
     * 相当于有两个背包,分别是大小为m的0背包和大小为n的1背包
     * 在装入物品的时候，需要同时向两个背包装入指定大小的0和1
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 对于dp[i][j]，用于记录容量为i的0背包和容量为1的1背吧可以装入的最大物品数
        int[][] dp = new int[m + 1][n + 1];
        // 用于记录使用了多少个字符串
        // 左上到右下 求取最优结构
        for (int i = 0; i < len; i++) {
            // 从物品栏中取出物品，计算0的数量和1的数量
            int[] count = convert(strs[i]);
            int v = count[0], w = count[1];
            for (int j = m; j >= v; j--) {
                for (int k = n; k >= w; k--) {
                    // 递推方程中使用到的数据是装入上一个物品时的背包状况
                    // 而这些数据在dp数组中的左上方
                    // 因此遍历的顺序应该是从右下到左上
                    dp[j][k] = Math.max(dp[j - v][k - w] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 双背包问题，基于三维dp数组求解
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        // 这里的dp[i][j][k]表示的是把前i个数据存入大小分别为j的0背包和大小为k的1背包中所能存入的最大物品数
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] count = convert(strs[i - 1]);
            int v = count[0], w = count[1];
            // 下面进行遍历的时候需要从0遍历
            // 字符中1和0的数量都可能为1
            // 从1开始遍历的话，就可能漏掉字符串中0或者1的数量为0的情况
            // 传统的0-1背包问题中，weight和value的值都是大于0的，所以从1遍历没啥问题
            // 也不可以从v和w开始遍历
            // 对于物品数为i的情况而言，需要把物品数为i-1在的状态复制到i状态
            // 上面得二维数组压缩情况就不需要考虑这点
            // 从右下遍历到左上，为被遍历的数据就是上一个状态的数据
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= v && k >= w)
                        dp[i][j][k] = Math.max(dp[i - 1][j - v][k - w] + 1, dp[i - 1][j][k]);
                    else
                        dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] convert(String str) {
        int count0 = 0, count1 = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        return new int[]{count0, count1};
    }

    public static void main(String[] args) {
        new FindMaxForm().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        new FindMaxForm().findMaxForm1(new String[]{"10", "1", "0"}, 1, 1);
        new FindMaxForm().findMaxForm(new String[]{"10", "1", "0"}, 1, 1);
    }
}
