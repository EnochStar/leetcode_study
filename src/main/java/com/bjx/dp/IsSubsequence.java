package com.bjx.dp;

/**
 * @author EnochStar
 * @title: IsSubsequence
 * @projectName leetcode_study
 * @description: 
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 *
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 *
 * ���ף�
 *
 * ����д�������� S������ S1, S2, ... , Sk ���� k >= 10�ڣ�����Ҫ���μ�������Ƿ�Ϊ T �������С�����������£���������ı���룿
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "abc", t = "ahbgdc"
 * �����true
 * ʾ�� 2��
 *
 * ���룺s = "axc", t = "ahbgdc"
 * �����false
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/is-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/22 14:26
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean[][] table = new boolean[s.length() + 1][t.length() + 1];
        for(int i = 0;i < table[0].length;i++) {
            table[0][i] = true;
        }
        for(int row = 1;row < table.length;row++) {
            char c1 = s.charAt(row - 1);
            for(int col = 1;col < table[0].length;col++) {
                char c2 = t.charAt(col - 1);
                if(c1 == c2) table[row][col] = table[row - 1][col - 1];
                else table[row][col] = table[row][col - 1];
            }
        }
        return table[table.length - 1][table[0].length - 1];
    }
}
