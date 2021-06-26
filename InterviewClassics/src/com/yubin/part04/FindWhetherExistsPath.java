package com.yubin.part04;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author MIIAMOR
 * @date 2021/6/26 19:08
 * medium
 */
public class FindWhetherExistsPath {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (n == 0 || graph == null) return false;
//        return findWhetherExistsPath1(n, graph, start, target);
//        return findWhetherExistsPath2(n, graph, start, target);
        return findWhetherExistsPath3(n, graph, start, target);
//        return findWhetherExistsPath4(n, graph, start, target);
//        return findWhetherExistsPath5(n, graph, start, target);
//        return findWhetherExistsPath6(n, graph, start, target);
    }

    /**
     * 根据起点求，有向边在数组中的下标
     */
    private int[][] getIndex(int n, int start, int[][] graph) {
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            index[i][0] = index[i][1] = -1;
        }
        int pre = graph[0][0], count = 0;
        index[graph[0][0]][0] = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == pre) count++;
            else {
                index[pre][1] = index[pre][0] + count - 1;
                pre = graph[i][0];
                index[pre][0] = i;
                count = 1;
            }
        }
        index[pre][1] = index[pre][0] + count - 1;
        return index;
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * 记录每个起点的有向边的索引
     */
    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        Arrays.sort(graph, (array1, array2) -> {
            if (array1[0] > array2[0]) return 1;
            else if (array1[0] < array2[0]) return -1;
            else return array1[1] - array2[1];
        });
        int[][] index = getIndex(n, start, graph);
        return dfs(start, visited, index, graph, target);
    }

    private boolean dfs(int start, boolean[] visited, int[][] index, int[][] graph, int target) {
        if (start == target) return true;
        if (index[start][1] == -1) return false;
        visited[start] = true;
        for (int i = index[start][0]; i <= index[start][1]; i++) {
            if (!visited[graph[i][1]])
                if (dfs(graph[i][1], visited, index, graph, target)) return true;
        }
        visited[start] = false;
        return false;
    }

    /**
     * 学习的提交第一那个大佬的
     * -------------------------------------------------------------------------------------------------------------------------
     * 为了知道能不能到达target，那么就需要知道可以可以到达target的前面那个点
     */
    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        return dfsFrontToBack(graph, visited, start, target);
    }

    private boolean dfsBackToFront(int[][] graph, boolean[] visited, int start, int target) {
        if (start == target) return true;
        visited[target] = true;
        for (int[] edge : graph) {
            if (edge[1] == target && !visited[edge[0]])
                if (dfsBackToFront(graph, visited, start, edge[0])) return true;
        }
        visited[target] = false;
        return false;
    }

    public boolean findWhetherExistsPath3(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        return dfsBackToFront(graph, visited, start, target);
    }

    private boolean dfsFrontToBack(int[][] graph, boolean[] visited, int start, int target) {
        if (start == target) return true;
        visited[start] = true;
        for (int[] edge : graph) {
            if (edge[0] == start && !visited[edge[1]])
                if (dfsBackToFront(graph, visited, edge[1], target)) return true;
        }
        visited[start] = false;
        return false;
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * 广度优先搜索解题(事先对edge们排好序)
     */
    public boolean findWhetherExistsPath5(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        Arrays.sort(graph, (array1, array2) -> {
            if (array1[0] > array2[0]) return 1;
            else if (array1[0] < array2[0]) return -1;
            else return array1[1] - array2[1];
        });
        int[][] index = getIndex(n, start, graph);
        LinkedList<Integer> point = new LinkedList<>();
        point.add(start);
        visited[start] = true;
        while (true) {
            int size = point.size();
            if (size == 0) return false;
            for (int i = 0; i < size; i++) {
                int edge = point.removeFirst();
                if (index[edge][0] == -1) continue;
                for (int k = index[edge][0]; k <= index[edge][1]; k++) {
                    int next = graph[k][1];
                    if (!visited[next]) {
                        if (next == target) return true;
                        point.addLast(next);
                    }
                }
            }
        }
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * 广度优先搜索解题(不排序):超时
     */
    public boolean findWhetherExistsPath4(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> point = new LinkedList<>();
        point.add(start);
        visited[start] = true;
        while (true) {
            int size = point.size();
            if (size == 0) return false;
            for (int i = 0; i < size; i++) {
                int edgePre = point.removeFirst();
                for (int[] edge : graph) {
                    if (edgePre == edge[0] && !visited[edge[1]]) {
                        if (edge[1] == target) return true;
                        point.addLast(edge[1]);
                    }
                }
            }
        }
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------------
     * 邻接矩阵 内存超了
     */
    private int[][] matrix;

    public boolean findWhetherExistsPath6(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        matrix = new int[n][n];
        for (int[] index : graph) {
            if (matrix[index[0]][index[1]] == 0)
                matrix[index[0]][index[1]] = 1;
        }
        return backtracking(start, target, visited);
    }

    /**
     * 使用回溯算法寻找通路
     */
    private boolean backtracking(int start, int target, boolean[] visited) {
        if (start == target) return true;
        if (!visited[start]) {
            visited[start] = true;
            for (int i = 0; i < matrix[start].length; i++) {
                if (matrix[start][i] == 1) {
                    if (backtracking(i, target, visited)) return true;
                }
            }
            visited[start] = false;
        }
        return false;
    }
}
