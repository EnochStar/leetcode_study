package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MinCostClimbingStairs
 * @projectName leetcode_study
 * @description: 
 * �����ÿ��������Ϊһ�����ݣ��� i�����ݶ�Ӧ��һ���Ǹ�������������ֵ cost[i](������0��ʼ)��
 *
 * ÿ��������һ�������㶼Ҫ���Ѷ�Ӧ����������ֵ��Ȼ�������ѡ�������һ�����ݻ������������ݡ�
 *
 * ����Ҫ�ҵ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ�������Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
 *
 * ʾ�� 1:
 *
 * ����: cost = [10, 15, 20]
 * ���: 15
 * ����: ��ͻ����Ǵ�cost[1]��ʼ��Ȼ�����������ɵ����ݶ���һ������15��
 *  ʾ�� 2:
 *
 * ����: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * ���: 6
 * ����: ��ͻ��ѷ�ʽ�Ǵ�cost[0]��ʼ�����������Щ1������cost[3]��һ������6��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/23 9:26
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        dp[0] = 0;
        dp[1] = cost[0];
        for(int i = 2;i < dp.length;i++) {
            if(i - 1 < cost.length)
                dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i - 1];
            else dp[i] = Math.min(dp[i - 1],dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
