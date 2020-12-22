package com.bjx.dp;

/**
 * @author EnochStar
 * @title: SellStock
 * @projectName leetcode_study
 * @description:
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
 *
 * ע�⣺�㲻���������Ʊǰ������Ʊ��
 *
 * ʾ�� 1:
 *
 * ����: [7,1,5,3,6,4]
 * ���: 5
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 *      ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
 * ʾ�� 2:
 *
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: �����������, û�н������, �����������Ϊ 0��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/22 12:01
 */
public class SellStock {
    // ������
    // public int maxProfit(int[] prices) {
    //     if(prices == null || prices.length == 0) return 0;
    //     int max = 0;
    //     int len = prices.length;
    //     for(int i = 0;i < len;i++) {
    //         for(int j = i + 1;j < len;j++) {
    //             if(prices[j] > prices[i]){
    //                 int temp = prices[j] - prices[i];
    //                 if(temp > max) max = temp;
    //             }
    //         }
    //     }
    //     return max;
    // }

    //��̬�滮
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1;i < len;i++) {
            if(prices[i] < min) min = prices[i];
            dp[i] = Math.max(dp[i - 1],prices[i] - min);
        }
        return dp[len - 1];
    }
}
