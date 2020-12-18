package com.bjx.dp;

import java.util.Arrays;

/**
 * @author EnochStar
 * @title: CoinChange
 * @projectName leetcode_study
 * @description:
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ����� -1��
 *
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3 
 * ���ͣ�11 = 5 + 5 + 1
 * ʾ�� 2��
 *
 * ���룺coins = [2], amount = 3
 * �����-1
 * ʾ�� 3��
 *
 * ���룺coins = [1], amount = 0
 * �����0
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/coin-change
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/16 18:42
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 1; i <= amount;i++) {
            for(int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i-coin] + 1,dp[i]);
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
}
