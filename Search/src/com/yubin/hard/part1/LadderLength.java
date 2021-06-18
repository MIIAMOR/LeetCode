package com.yubin.hard.part1;

import java.util.*;

public class LadderLength {
    /**
     * 从上到下依次是 ：
     * 单词到计数器的映射
     * 每个单词可以变换一个字符而得到的虚拟单词节点
     * 这个单词是否被访问
     * 单词在wordList中的计数号
     */
    private Map<String, Integer> wordCount = null;
    private List<List<Integer>> edge = null;
    private boolean[] visited = null;
    private int count = 0;

    /**
     * 长度为n的单词将对应n个虚拟节点
     * 可以相互转换的单词毕竟连着着同一个虚拟节点
     *
     * @param word 为每个单词节点创建虚拟节点
     */
    private void addEdge(String word) {
        addWord(word);
        int wordId = wordCount.get(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            chars[i] = '*';
            String newWord = String.valueOf(chars);
            addWord(newWord);
            int newWordId = wordCount.get(newWord);
            edge.get(newWordId).add(wordId);
            edge.get(wordId).add(newWordId);
            chars[i] = tmp;
        }
    }

    /**
     * 为每个单词添加映射的号码
     *
     * @param word 待添加的单词
     */
    private void addWord(String word) {
        if (!wordCount.containsKey(word)) {
            wordCount.put(word, count++);
            edge.add(new ArrayList<>());
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 初始化
        wordCount = new HashMap<>();
        edge = new ArrayList<>();
        count = 0;
        // 建立图结构
        addEdge(beginWord);
        for (String s : wordList) {
            addEdge(s);
        }
        visited = new boolean[edge.size()];
        // endWord不在映射表中的时候,返回0
        if (!wordCount.containsKey(endWord)) return 0;
        // 进行bfs搜索 寻找到达endWord的最短路径
        int endId = wordCount.get(endWord);
        int beginId = wordCount.get(beginWord);
        LinkedList<Integer> currLevel = new LinkedList<>();
        currLevel.add(beginId);
        int depth = 0;// bfs时探索的深度
        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            for (int i = 0; i < size; i++) {
                int id = currLevel.removeFirst();
                visited[id] = true;
                if (id == endId) return depth / 2 + 1;
                for (Integer nextId : edge.get(id)) {
                    if (!visited[nextId])
                        currLevel.addLast(nextId);
                }
            }
            depth++;
        }
        return 0;
    }

    public void test() {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
    }

    public static void main(String[] args) {
        new LadderLength().test();
    }
}
