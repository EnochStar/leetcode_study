package com.bjx.greedy;

import java.util.Arrays;

/**
 * @author EnochStar
 * @title: AssignCookie
 * @projectName leetcode_study
 * @description: 
 * ���1��
 * ʾ�� 2:
 *
 * ����: g = [1,2], s = [1,2,3]
 * ���: 2
 * ����: 
 * �����������Ӻ�����С���ɣ�2�����ӵ�θ��ֵ�ֱ���1,2��
 * ��ӵ�еı��������ͳߴ綼���������к������㡣
 * ������Ӧ�����2.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/assign-cookies
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/19 11:00
 */
public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
