package com.bjx.every;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * 题目分析：给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 分析：
 * 广度遍历，遍历开始字符的每一个单词进行从‘a’-‘z’的变化，如果字典中包含，就形成新的开始序列。
 * 当字典中不包含对开始字符串的任意一个字符改变时，说明无法到达endword。
 * 为了提高效率可以采用双端广度遍历，选择头-》尾 和尾-》头中形成较短的字符集进行遍历。
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> beginSet = new HashSet();
        HashSet<String> endSet = new HashSet();
        HashSet<String> all = new HashSet(wordList);
        if (!all.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        return bfs(beginSet, endSet, all, 2);
    }

    public int bfs(Set<String> bs, Set<String> es, Set<String> as, int num) {
        if (bs.size() == 0) {
            return 0;
        }
        if (bs.size() > es.size()) {
            return bfs(es, bs, as, num);
        }
        as.removeAll(bs);
        HashSet<String> next = new HashSet<>();
        // 遍历开始字段的每一个值，获取修改一个单词的序列
        for (String s : bs) {
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char temp = cs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if(temp == c){
                        continue;
                    }
                    cs[i] = c;
                    String temps = new String(cs);
                    if (as.contains(temps)) {
                        if (es.contains(temps)) {
                            return num;
                        } else {
                            next.add(temps);
                        }
                    }
                }
                cs[i] = temp;
            }
        }
        return bfs(next, es, as, num + 1);
    }
}
