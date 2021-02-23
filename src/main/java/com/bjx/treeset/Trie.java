package com.bjx.treeset;

/**
 * @author EnochStar
 * @title: Trie
 * @projectName leetcode_study
 * @description: 
 * ʵ��һ�� Trie (ǰ׺��)������ insert, search, �� startsWith ������������
 *
 * ʾ��:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // ���� true
 * trie.search("app");     // ���� false
 * trie.startsWith("app"); // ���� true
 * trie.insert("app");   
 * trie.search("app");     // ���� true
 * ˵��:
 *
 * ����Լ������е����붼����Сд��ĸ a-z ���ɵġ�
 * ��֤���������Ϊ�ǿ��ַ�����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/23 14:51
 */
public class Trie {
    private boolean isEnd;
    private Trie next[] = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {}

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char[] w = word.toCharArray();
        for(int i = 0;i < w.length;i++) {
            if(root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
            root = root.next[w[i] - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        char[] w = word.toCharArray();
        for(int i = 0;i < w.length;i++) {
            if(root.next[w[i] - 'a'] == null) return false;
            root = root.next[w[i] - 'a'];
        }
        return root.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] p = prefix.toCharArray();
        for(int i = 0;i < p.length;i++) {
            if(root.next[p[i] - 'a'] == null) return false;
            root = root.next[p[i] - 'a'];
        }
        return true;
    }
}
