package com.bjx.dp;

import java.util.Arrays;

/**
 * @author EnochStar
 * @title: ThreeSteps
 * @projectName leetcode_study
 * @description:
 * �������⡣�и�С��������¥�ݣ�¥����n��̨�ף�С��һ�ο�����1�ס�2�׻�3�ס�ʵ��һ�ַ���������С���ж�������¥�ݵķ�ʽ��������ܴܺ�����Ҫ�Խ��ģ1000000007��
 *
 * ʾ��1:
 *
 *  ���룺n = 3
 *  �����4
 *  ˵��: �������߷�
 * ʾ��2:
 *
 *  ���룺n = 5
 *  �����13
 * ��ʾ:
 *
 * n��Χ��[1, 1000000]֮��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/three-steps-problem-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/23 9:48
 */
public class ThreeSteps {
    public int waysToStep(int n) {
        long[] dp = new long[n + 1];
        if(n <= 2) return n;
        if(n == 3) return 4;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4;i <= n;i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n];
    }
}
