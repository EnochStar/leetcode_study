package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: PermutationSimple
 * @projectName leetcode_study
 * @description:
 * ���ظ��ַ�����������ϡ���дһ�ַ���������ĳ�ַ���������������ϣ��ַ���ÿ���ַ�������ͬ��
 *
 * ʾ��1:
 *
 *  ���룺S = "qwe"
 *  �����["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * ʾ��2:
 *
 *  ���룺S = "ab"
 *  �����["ab", "ba"]
 * ��ʾ:
 *
 * �ַ�����Ӣ����ĸ��
 * �ַ���������[1, 9]֮�䡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutation-i-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/12 21:58
 */
public class PermutationSimple {
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] c = S.toCharArray();
        boolean[] flag = new boolean[c.length];
        backtrack(new StringBuilder(),c,flag);
        return list.toArray(new String[0]);
    }
    void backtrack(StringBuilder sb,char[] c,boolean[] flag) {
        if (sb.length() == c.length) {
            list.add(sb.toString());
        }
        for (int i = 0; i < c.length;i++) {
            if (flag[i])
                continue;
            sb.append(c[i]);
            flag[i] = true;
            backtrack(sb,c,flag);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}
