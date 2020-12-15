package com.bjx.bfs;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author EnochStar
 * @title: WordLadder
 * @projectName leetcode_study
 * @description:
 * �����������ʣ�beginWord�� endWord����һ���ֵ䣬�ҵ���beginWord ��endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 *
 * ���������������ת�����У����� 0��
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 * ʾ��1:
 *
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * ���: 5
 *
 * ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      �������ĳ��� 5��
 * ʾ�� 2:
 *
 * ����:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * ���:0
 *
 * ����:endWord "cog" �����ֵ��У������޷�����ת����
 *
 * ˼·�����������Ѿ�֪�������յ㣬�ʿ��Բ���˫��bfs
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-ladder
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
