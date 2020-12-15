package com.bjx.bfs;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author EnochStar
 * @title: WordLadder
 * @projectName leetcode_study
 * @description:
 * 给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出:0
 *
 * 解释:endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 思路：本题由于已经知道起点和终点，故可以采用双向bfs
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/15 12:18
 */
public class WordLadder {
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     int depth = 1;
    //     if (!wordList.contains(endWord)) return 0;
    //     Queue<String> queue = new LinkedList<>();
    //     queue.add(beginWord);
    //     boolean[] visited = new boolean[wordList.size()];
    //     while (!queue.isEmpty()) {
    //         depth++;
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             String cur = queue.poll();
    //             for (int i = 0;i < wordList.size();i++) {
    //                 if (visited[i]) continue;
    //                 if (canChange(cur,wordList.get(i))){
    //                     if (wordList.get(i).equals(endWord)) return depth;
    //                     queue.add(wordList.get(i));
    //                     visited[i] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return 0;
    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int depth = 1;
        if(!wordList.contains(endWord)) return 0;
        Set<String> q1 = new HashSet();
        Set<String> q2 = new HashSet();
        Set<String> visited = new HashSet();
        q1.add(beginWord);
        q2.add(endWord);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet();
            for(String cur : q1) {
                if(q2.contains(cur)) return depth;
                visited.add(cur);
                for(int i = 0;i < wordList.size();i++) {
                    String s = wordList.get(i);
                    if(canChange(cur,s)) {
                        if(visited.contains(s)) continue;
                        temp.add(s);
                    }
                }
            }
            if(temp.size() < q2.size()) {
                q1 = temp;
            }else{
                q1 = q2;
                q2 = temp;
            }
            depth++;
        }
        return 0;
    }
    boolean canChange(String source,String expected) {
        int count = 0;
        for (int i = 0;i < source.length();i++) {
            if (source.charAt(i) != expected.charAt(i)) count++;
        }
        return count == 1;
    }
}
