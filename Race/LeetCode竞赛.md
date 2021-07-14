# LeetCode周赛

## week247

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

## week248

### 1. [基于排列构建数组](https://leetcode-cn.com/problems/build-array-from-permutation/)

给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。

从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。

 

示例 1：

> 输入：nums = [0,2,1,5,3,4]
> 输出：[0,1,2,4,5,3]
> 解释：数组 ans 构建如下：
> ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
>     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
>     = [0,1,2,4,5,3]

```java
package com.yubin.week248;

/**
 * @author MIIAMOR
 * @date 2021/7/4 18:50
 */
public class BuildArray {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
```

### 2. [消灭怪物的最大数量](https://leetcode-cn.com/problems/eliminate-maximum-number-of-monsters/)

你正在玩一款电子游戏，在游戏中你需要保护城市免受怪物侵袭。给你一个 下标从 0 开始 且长度为 n 的整数数组 dist ，其中 dist[i] 是第 i 个怪物与城市的 初始距离（单位：米）。

怪物以 恒定 的速度走向城市。给你一个长度为 n 的整数数组 speed 表示每个怪物的速度，其中 speed[i] 是第 i 个怪物的速度（单位：米/分）。

怪物从 第 0 分钟 时开始移动。你有一把武器，并可以 选择 在每一分钟的开始时使用，包括第 0 分钟。但是你无法在一分钟的中间使用武器。这种武器威力惊人，一次可以消灭任一还活着的怪物。

一旦任一怪物到达城市，你就输掉了这场游戏。如果某个怪物 恰 在某一分钟开始时到达城市，这会被视为 输掉 游戏，在你可以使用武器之前，游戏就会结束。

返回在你输掉游戏前可以消灭的怪物的 最大 数量。如果你可以在所有怪物到达城市前将它们全部消灭，返回  n 。

 

示例 1：

> 输入：dist = [1,3,4], speed = [1,1,1]
> 输出：3
> 解释：
> 第 0 分钟开始时，怪物的距离是 [1,3,4]，你消灭了第一个怪物。
> 第 1 分钟开始时，怪物的距离是 [X,2,3]，你没有消灭任何怪物。
> 第 2 分钟开始时，怪物的距离是 [X,1,2]，你消灭了第二个怪物。
> 第 3 分钟开始时，怪物的距离是 [X,X,1]，你消灭了第三个怪物。
> 所有 3 个怪物都可以被消灭。

```java
package com.yubin.week248;

import java.util.Arrays;

/**
 * @author MIIAMOR
 * @date 2021/7/4 18:54
 */
public class EliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        // 计算每个怪物到达的时间，然后遍历时间，一分钟消灭一个
        // 当怪物到达的时间少于当前的时间，说明此时无法消灭这个怪物
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = 1.0 * dist[i] / speed[i];
        }
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            if (i >= time[i]) return i;
        }
        return n;
    }
}
```

### 3. [统计好数字的数目](https://leetcode-cn.com/problems/count-good-numbers/)

我们称一个数字字符串是 好数字 当它满足（下标从 0 开始）偶数 下标处的数字为 偶数 且 奇数 下标处的数字为 质数 （2，3，5 或 7）。

比方说，"2582" 是好数字，因为偶数下标处的数字（2 和 8）是偶数且奇数下标处的数字（5 和 2）为质数。但 "3245" 不是 好数字，因为 3 在偶数下标处但不是偶数。
给你一个整数 n ，请你返回长度为 n 且为好数字的数字字符串 总数 。由于答案可能会很大，请你将它对 109 + 7 取余后返回 。

一个 数字字符串 是每一位都由 0 到 9 组成的字符串，且可能包含前导 0 。

 

示例 1：

> 输入：n = 1
> 输出：5
> 解释：长度为 1 的好数字包括 "0"，"2"，"4"，"6"，"8" 。

```java
package com.yubin.week248;

/**
 * @author MIIAMOR
 * @date 2021/7/4 21:24
 */
public class CountGoodNumbers {
    private final long mod = (long) (1e9 + 7);

    /**
     * 对于一个数，奇数位置有四种选择2，3，5，7，偶数位置有五种选择0，2，4，6，8
     */
    public int countGoodNumbers(long n) {
        // 对于n而言，他的偶数位置数量为(n + 1) / 2，奇数位数量为n - even
        long even = (n + 1) / 2, odd = n / 2;
        long res = quickPow(5, even) * quickPow(4, odd) % mod;
        return (int) res;
    }

    /**
     * 利用二进制计算幂数
     */
    private long quickPow(long a, long b) {
        long res = 1;
        while ((b) != 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            b = b >> 1;
            a = a * a % mod;
        }
        return res;
    }
}
```

### *4. [最长公共子路径](https://leetcode-cn.com/problems/longest-common-subpath/)

一个国家由 n 个编号为 0 到 n - 1 的城市组成。在这个国家里，每两个 城市之间都有一条道路连接。

总共有 m 个编号为 0 到 m - 1 的朋友想在这个国家旅游。他们每一个人的路径都会包含一些城市。每条路径都由一个整数数组表示，每个整数数组表示一个朋友按顺序访问过的城市序列。同一个城市在一条路径中可能 重复 出现，但同一个城市在一条路径中不会连续出现。

给你一个整数 n 和二维数组 paths ，其中 paths[i] 是一个整数数组，表示第 i 个朋友走过的路径，请你返回 每一个 朋友都走过的 最长公共子路径 的长度，如果不存在公共子路径，请你返回 0 。

一个 子路径 指的是一条路径中连续的城市序列。

 

示例 1：

> 输入：n = 5, paths = [[0,1,2,3,4],
>                      [2,3,4],
>                      [4,0,1,2,3]]
> 输出：2
> 解释：最长公共子路径为 [2,3] 。



## week249

### 1. [数组串联](https://leetcode-cn.com/contest/weekly-contest-249/problems/concatenation-of-array/)

给你一个长度为 `n` 的整数数组 `nums` 。请你构建一个长度为 `2n` 的答案数组 `ans` ，数组下标 **从 0 开始计数** ，对于所有 `0 <= i < n` 的 `i` ，满足下述所有要求：

- `ans[i] == nums[i]`
- `ans[i + n] == nums[i]`

具体而言，`ans` 由两个 `nums` 数组 **串联** 形成。

```java
package com.yubin.week249;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:06
 */
public class GetConcatenation {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int len = nums.length;
            int[] res = new int[2 * len];
            for (int i = 0; i < len; i++) {
                res[i] = res[i + len] = nums[i];
            }
            return res;
        }
    }
}
```

### 2.  [长度为 3的不同回文子序列](https://leetcode-cn.com/contest/weekly-contest-249/problems/unique-length-3-palindromic-subsequences/)

即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。

**回文** 是正着读和反着读一样的字符串。

**子序列** 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。

- 例如，`"ace"` 是 `"***a\***b***c\***d***e\***"` 的一个子序列。

```java
package com.yubin.week249;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:07
 */
public class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        char[] c = s.toCharArray();
        boolean[] mark = new boolean[26];
        int n = c.length;
        int res = 0;
        int l = 0, r = n - 1;
        while (r > l) {
            if (mark[c[l] - 'a']) {
                l++;
                continue;
            }
            for (int i = r; i > l + 1; i--) {
                if (c[i] == c[l]) {
                    Set<Character> set = new HashSet<>();
                    for (int j = l + 1; j < i; j++) set.add(c[j]);
                    res += (set.size());
                    mark[c[l] - 'a'] = true;
                    break;
                }
            }
            l++;
        }
        return res;
    }
}
```

### *3. [用三种不同颜色为网格涂色](https://leetcode-cn.com/contest/weekly-contest-249/problems/painting-a-grid-with-three-different-colors/)

给你两个整数 `m` 和 `n` 。构造一个 `m x n` 的网格，其中每个单元格最开始是白色。请你用 **红、绿、蓝** 三种颜色为每个单元格涂色。所有单元格都需要被涂色。

涂色方案需要满足：**不存在相邻两个单元格颜色相同的情况** 。返回网格涂色的方法数。因为答案可能非常大， 返回 **对** `109 + 7` **取余** 的结果。





### *4. [合并多棵二叉搜索树](https://leetcode-cn.com/contest/weekly-contest-249/problems/merge-bsts-to-create-single-bst/)

给你 `n` 个 **二叉搜索树的根节点** ，存储在数组 `trees` 中（**下标从 0 开始**），对应 `n` 棵不同的二叉搜索树。`trees` 中的每棵二叉搜索树 **最多有 3 个节点** ，且不存在值相同的两个根节点。在一步操作中，将会完成下述步骤：

- 选择两个 **不同的** 下标 `i` 和 `j` ，要求满足在 `trees[i]` 中的某个 **叶节点** 的值等于 `trees[j]` 的 **根节点的值** 。
- 用 `trees[j]` 替换 `trees[i]` 中的那个叶节点。
- 从 `trees` 中移除 `trees[j]` 。

如果在执行 `n - 1` 次操作后，能形成一棵有效的二叉搜索树，则返回结果二叉树的 **根节点** ；如果无法构造一棵有效的二叉搜索树*，*返回 `null` 。

二叉搜索树是一种二叉树，且树中每个节点均满足下述属性：

- 任意节点的左子树中的值都 **严格小于** 此节点的值。
- 任意节点的右子树中的值都 **严格大于** 此节点的值。

叶节点是不含子节点的节点。



# LeetCode双周赛

## dweek56

### 1. [统计平方和三元组的数目](https://leetcode-cn.com/problems/count-square-sum-triples/)

一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。

给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。

```java
package com.yubin.dweek56;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:11
 */
public class CountTriples {
    public int countTriples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++)
                    if (i * i + j * j == k * k) res++;
        return res;
    }
}
```

### 2. [迷宫中离入口最近的出口](https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/)

给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。

每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。

请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。

```java
package com.yubin.dweek56;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/7/11 11:13
 */
public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int[][] dist = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[entrance[0]][entrance[1]] = 0;
        q.add(new int[]{entrance[0], entrance[1]});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.removeFirst();
                int x = pos[0], y = pos[1];
                if (x == 0 || x == m - 1 || y == 0 || y == n - 1)
                    if (x != entrance[0] || y != entrance[1]) return dist[x][y];
                int u = pos[0] - 1, d = pos[0] + 1, l = pos[1] - 1, r = pos[1] + 1;
                int curr = dist[x][y];
                if (u >= 0 && maze[u][y] == '.' && dist[u][y] == Integer.MAX_VALUE) {
                    dist[u][y] = curr + 1;
                    q.addLast(new int[]{u, y});
                }
                if (d < m && maze[d][y] == '.' && dist[d][y] == Integer.MAX_VALUE) {
                    dist[d][y] = curr + 1;
                    q.addLast(new int[]{d, y});
                }
                if (l >= 0 && maze[x][l] == '.' && dist[x][l] == Integer.MAX_VALUE) {
                    dist[x][l] = curr + 1;
                    q.addLast(new int[]{x, l});
                }
                if (r < n && maze[x][r] == '.' && dist[x][r] == Integer.MAX_VALUE) {
                    dist[x][r] = curr + 1;
                    q.addLast(new int[]{x, r});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NearestExit().nearestExit(new char[][]{
                {'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}
        }, new int[]{1, 0}));
    }
}
```

### *3. [求和游戏](https://leetcode-cn.com/problems/sum-game/)

Alice 和 Bob 玩一个游戏，两人轮流行动，Alice 先手 。

给你一个 偶数长度 的字符串 num ，每一个字符为数字字符或者 '?' 。每一次操作中，如果 num 中至少有一个 '?' ，那么玩家可以执行以下操作：

选择一个下标 i 满足 num[i] == '?' 。
将 num[i] 用 '0' 到 '9' 之间的一个数字字符替代。
当 num 中没有 '?' 时，游戏结束。

Bob 获胜的条件是 num 中前一半数字的和 等于 后一半数字的和。Alice 获胜的条件是前一半的和与后一半的和 不相等 。

比方说，游戏结束时 num = "243801" ，那么 Bob 获胜，因为 2+4+3 = 8+0+1 。如果游戏结束时 num = "243803" ，那么 Alice 获胜，因为 2+4+3 != 8+0+3 。
在 Alice 和 Bob 都采取 最优 策略的前提下，如果 Alice 获胜，请返回 true ，如果 Bob 获胜，请返回 false 。

### *4. [规定时间内到达终点的最小花费](https://leetcode-cn.com/problems/minimum-cost-to-reach-destination-in-time/)

一个国家有 n 个城市，城市编号为 0 到 n - 1 ，题目保证 所有城市 都由双向道路 连接在一起 。道路由二维整数数组 edges 表示，其中 edges[i] = [xi, yi, timei] 表示城市 xi 和 yi 之间有一条双向道路，耗费时间为 timei 分钟。两个城市之间可能会有多条耗费时间不同的道路，但是不会有道路两头连接着同一座城市。

每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j] 是你经过城市 j 需要支付的费用。

一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费之和 （包括 起点和终点城市的通行费）。

给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -1 。

