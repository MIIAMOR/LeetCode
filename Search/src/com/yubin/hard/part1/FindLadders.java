package com.yubin.hard.part1;

import java.util.*;

public class FindLadders {
    /**
     * 测试两个单词是否只有一个字符之差
     */
    private boolean testWord(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int flag = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) flag++;
            if (flag == 2) return false;
        }
        return flag == 1;
    }

    /**
     * -------------------------------------------------------------------------------------------------------
     * 思路2：
     * 使用bfs思想，从endWord向beginWord扩展，第一次遇到beginWord，就意味着是最短路径
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();//最终结果
        if (!wordList.contains(endWord)) return ans;

        // 从endWord构造的树结构的根节点
        Node root = new Node(endWord);
        root.parents = new LinkedList<>();
        LinkedList<Node> currNodes = new LinkedList<>();

        currNodes.add(root);

        while (true) {
            int flag = 0;//记录是否遇到了beginWord
            int size = currNodes.size();
            if (size == 0) return ans;
            for (int i = 0; i < size; i++) {
                Node n = currNodes.removeFirst();
                if (testWord(n.word, beginWord)) {
                    Node node = new Node(beginWord);
                    node.parents = new LinkedList<>(n.parents);
                    node.parents.addFirst(n.word);
                    node.parents.addFirst(beginWord);
                    ans.add(node.parents);
                    flag++;
                    continue;
                }
                for (String nextWord : wordList) {
                    if (testWord(n.word, nextWord) && !n.parents.contains(nextWord)) {
                        Node node = new Node(nextWord);
                        node.parents = new LinkedList<>(n.parents);
                        node.parents.addFirst(n.word);
                        currNodes.addLast(node);
                    }
                }
            }
            if (flag != 0) return ans;
        }
    }


    /**
     * 记录一个单词和可以与他转化得到的单词
     */
    private static class Node {
        // 单词 子节点 所有出现过的父辈节点
        String word;
        LinkedList<String> parents;

        public Node(String word) {
            this.word = word;
        }
    }

    /**
     * -------------------------------------------------------------------------------------------------------
     * 思路1
     * 从beginWord开始，使用bfs进行遍历，遇到endWord则对比List长度
     * 若果长度等于res中的元素长度，就添加
     * 小于，则清空res再添加
     * 大于，则直接返回
     */
    /**
     * 记录最终的结果 临时记录结果数据项的List 记录是否访问的字段
     */
    private List<List<String>> res = null;
    private LinkedList<String> list = null;
    private String endWord = null;
    private boolean[] visited = null;

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        res = new LinkedList<>();
        if (beginWord.length() != endWord.length()) return res;
        list = new LinkedList<>();
        visited = new boolean[wordList.size()];
        this.endWord = endWord;
        list.add(beginWord);
        dfs(wordList, beginWord, 1);
        return res;
    }

    /**
     * 进行深度优先遍历，寻找最优解
     *
     * @param wordList 单词列表
     * @param preWord  单词接龙的上一个单词
     * @param size     当前已经进入的list的单词数
     */
    private void dfs(List<String> wordList, String preWord, int size) {
        if (size == wordList.size() + 1) return;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (!visited[i] && testWord(preWord, word)) {
                visited[i] = true;
                list.addLast(word);
                if (word.equals(endWord)) {
                    addRes();
                    list.removeLast();
                    visited[i] = false;
                    return;
                }
                dfs(wordList, word, size + 1);
                list.removeLast();
                visited[i] = false;
            }
        }
    }

    private void addRes() {
        if (res.size() != 0) {
            if (list.size() > res.get(0).size()) return;
            else if (list.size() == res.get(0).size()) {
                res.add(new LinkedList<>(list));
                return;
            }
        }
        res.clear();
        res.add(new LinkedList<>(list));
    }

    public void test() {
        for (List<String> ladder : findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))) {
            for (String s : ladder) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        for (List<String> ladder : findLadders("a", "c", Arrays.asList("a", "b", "c"))) {
            for (String s : ladder) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new FindLadders().test();
    }
}
