package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author EnochStar
 * @title: Partition
 * @projectName leetcode_study
 * @description: ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 *
 * ���� s ���п��ܵķָ����
 *
 * ʾ��:
 *
 * ����:"aab"
 * ���:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * ���ӣ�https://leetcode-cn.com/problems/palindrome-partitioning
 * @date 2020/12/615:51
 */
public class Partition {
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new LinkedList());
        return res;
    }
    void backtrack(String s, int start, LinkedList<String> list) {
        if(start == s.length()) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String s1 = s.substring(start,i + 1);
            if(!isPalindrome(s1)) {
                continue;
            }
            list.add(s1);
            backtrack(s, i + 1, list);
            list.removeLast();
        }
    }
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
