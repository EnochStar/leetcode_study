package com.bjx.treeset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: WordSearchII
 * @projectName leetcode_study
 * @description: ����һ�� m x n ��ά�ַ����� board ��һ�����ʣ��ַ������б� words���ҳ�����ͬʱ�ڶ�ά������ֵ��г��ֵĵ��ʡ�
 * <p>
 * ���ʱ��밴����ĸ˳��ͨ�� ���ڵĵ�Ԫ�� �ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * �����["eat","oath"]
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺board = [["a","b"],["c","d"]], words = ["abcb"]
 * �����[]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] ��һ��СдӢ����ĸ
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] ��СдӢ����ĸ���
 * words �е������ַ���������ͬ
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-search-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/23 16:10
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
