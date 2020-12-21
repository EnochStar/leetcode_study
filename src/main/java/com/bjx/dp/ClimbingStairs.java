package com.bjx.dp;

/**
 * @author EnochStar
 * @title: ClimbingStairs
 * @projectName leetcode_study
 * @description:
 * ������������¥�ݡ���Ҫ n?������ܵ���¥����
 *
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 *
 * ע�⣺���� n ��һ����������
 *
 * ʾ�� 1��
 *
 * ���룺 2
 * ����� 2
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 ��
 * 2.  2 ��
 * ʾ�� 2��
 *
 * ���룺 3
 * ����� 3
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 �� + 1 ��
 * 2.  1 �� + 2 ��
 * 3.  2 �� + 1 ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/climbing-stairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/21 10:50
 */
public class ClimbingStairs {
    // ����һ
    // public int climbStairs(int n) {
    //     if(n <= 3) {
    //         return n;
    //     }
    //     int[] dp = new int[n + 1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for(int i = ; i <= n;i++) {
    //         dp[i] = dp[i - 1] + dp[i - 2];
    //     }
    //     return dp[n];
    // }

    // ������

    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        int sum = 0;
        for(int i = 3; i <= n;i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
