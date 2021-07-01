# LeetCode周赛

## Week247

### 1. [两个数对之间的最大乘积差](https://leetcode-cn.com/problems/maximum-product-difference-between-two-pairs/)

两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。

例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。

返回以这种方式取得的乘积差中的 最大值 。

 

示例 1：

输入：nums = [5,6,2,7,4]
输出：34
解释：可以选出下标为 1 和 3 的元素构成第一个数对 (6, 7) 以及下标 2 和 4 构成第二个数对 (2, 4)
乘积差是 (6 * 7) - (2 * 4) = 34

```java
package com.yubin.week247;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/6/27 10:47
 */
public class MaxProductDifference {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1]);
    }
}
```

### 2. [循环轮转矩阵](https://leetcode-cn.com/problems/cyclically-rotating-a-grid/)

给你一个大小为 m x n 的整数矩阵 grid ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。

矩阵由若干层组成，如下图所示，每种颜色代表一层：



矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：


返回执行 k 次循环轮转操作后的矩阵。

 

示例 1：


输入：grid = [[40,10],[30,20]], k = 1
输出：[[10,20],[40,30]]
解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。

```java
package com.yubin.week247;

/**
 * @author MIIAMOR
 * @date 2021/6/27 10:49
 */
public class RotateGrid {
    /**
     * 思路：获取每一层第一个点移动k（去除冗余移动次数）后的下标
     * 在依次把数据复制过去
     */
    private int m, n;
    private int destI, destJ;// 每个层级中第一个方块，旋转k次后的坐标

    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int[][] res = new int[m][n];
        int level = Math.min(m, n) / 2;
        for (int l = 0; l < level; l++) {
            rotateLevel(grid, res, k, l);
        }
        return res;
    }

    private void rotateLevel(int[][] grid, int[][] res, int k, int level) {
        int len = 2 * (m + n - 4 * level) - 4;// 当前层级中方块的数量
        rotateKthIndex(level, k, len);
        int[] oriIndex = new int[]{level, level};
        int[] nextIndex = new int[]{destI, destJ};
        for (int count = 0; count < len; count++) {
            res[nextIndex[0]][nextIndex[1]] = grid[oriIndex[0]][oriIndex[1]];
            nextIndex(oriIndex, level);
            nextIndex(nextIndex, level);
        }
    }

    private void rotateKthIndex(int level, int k, int len) {
        k %= len;// 去除冗余的移动次数
        int[] index = new int[]{level, level};
        for (int i = 0; i < k; i++) {
            nextIndex(index, level);
        }
        destI = index[0];
        destJ = index[1];
    }

    /**
     * 获取当前点移动一次后的下标
     */
    private void nextIndex(int[] index, int level) {
        int i = index[0], j = index[1];
        if (i == level) {
            if (j == level) index[0]++;
            if (j > level) index[1]--;
        } else if (i == m - 1 - level) {
            if (j < n - 1 - level) index[1]++;
            if (j == n - 1 - level) index[0]--;
        } else if (j == level) {
            if (i < m - 1 - level) index[0]++;
        } else if (j == n - 1 - level) {
            if (i > level) index[0]--;
        }
    }
}
```

### *3. [最美子字符串的数目](https://leetcode-cn.com/problems/number-of-wonderful-substrings/)（未做）（前缀和）

如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。

例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。

子字符串 是字符串中的一个连续字符序列。

 

示例 1：

输入：word = "aba"
输出：4
解释：4 个最美子字符串如下所示：
- "aba" -> "a"
- "aba" -> "b"
- "aba" -> "a"
- "aba" -> "aba"

```java
package com.yubin.week247;

/**
 * @author MIIAMOR
 * @date 2021/6/27 11:36
 */
public class WonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        char[] chars = word.toCharArray();
        int[] count = new int[1024];
        count[0] = 1;
        long res = 0L;
        int pre = 0;
        for (char c : chars) {
            pre ^= (1 << (c - 'a'));
            res += count[pre];
            for (int i = 0; i < 10; i++) {
                res += count[pre ^ (1 << i)];
            }
            count[pre]++;
        }
        return res;
    }
}
```

### *4. [统计为蚁群构筑房间的不同顺序](https://leetcode-cn.com/problems/count-ways-to-build-rooms-in-an-ant-colony/)（未做）

请直接点开链接



# LeetCode双周赛

