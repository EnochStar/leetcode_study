package com.bjx.treeset;

/**
 * @author EnochStar
 * @title: Trie
 * @projectName leetcode_study
 * @description: 
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
