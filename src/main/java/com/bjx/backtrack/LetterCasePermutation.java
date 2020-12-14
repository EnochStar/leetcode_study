package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: LetterCasePermutation
 * @projectName leetcode_study
 * @description: ����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�
 *
 *
 * ʾ����
 * ���룺S = "a1b2"
 * �����["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * ���룺S = "3z4"
 * �����["3z4", "3Z4"]
 *
 * ���룺S = "12345"
 * �����["12345"]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/letter-case-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ˼·:����ĸ��Сдת�� ���� ���32 ������� ��(�ո��asciiֵΪ32) ����cתString ���� new String(c)
 * ע����ݵ�ʱ����
 * @date 2020/12/99:31
 */
public class LetterCasePermutation {
    List<String> list = new ArrayList();
    public List<String> letterCasePermutation(String S) {
        char[] c = S.toCharArray();
        backtrack(S,c,0);
        return list;
    }
    void backtrack(String s, char[] c, int index) {
        if(s.length() == index) {
            list.add(new String(c));
            return;
        }
        backtrack(s,c,index + 1);
        if(Character.isLetter(c[index])) {
            c[index] ^= ' ';
            backtrack(s,c,index + 1);
        }
    }
}
