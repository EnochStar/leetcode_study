package com.bjx.dp;

/**
 * @author EnochStar
 * @title: ZeroOneBag
 * @projectName leetcode_study
 * @description:
 * ���ӣ�https://ac.nowcoder.com/questionTerminal/7e157ce9a8c249daa3ddafad322dbf1e
 * ��Դ��ţ����
 *
 * ��ΪN����Ʒ�����ǵ�����w�ֱ���w1,w2,...,wn�����ǵļ�ֵv�ֱ���v1,v2,...,vn��ÿ����Ʒ�������ҽ���һ�������ڸ��������ΪM�ı������󱳰���װ�����Ʒ���еļ�ֵ����ܺͣ�
 *
 * ��������:
 * ��Ʒ����N=5��
 * ����w�ֱ���2 2 6 5 4
 * ��ֵv�ֱ���6 3 5 4 6
 * ��������ΪM=10
 *
 *
 * �������:
 * ��������Ʒ����ܺ�Ϊ15
 * ʾ��1
 * ����
 * 5
 * 10
 * 2 2 6 5 4
 * 6 3 5 4 6
 * ���
 * 15
 * @date 2021/1/1 10:51
 */
public class ZeroOneBag {
    public int dp(int num,int weight,int[] w,int[] v) {
        int[][] dp = new int[num + 1][weight + 1];
        // ��������������Ϊ0ʱ��������ֵΪ0
        for(int i = 0;i <= num;i++) {
            dp[i][0] = 0;
        }
        // ��û����Ʒʱ������������ֵΪ0
        for(int i = 0;i <= num;i++) {
            dp[0][i] = 0;
        }
        // ����ǰi����Ʒ����ǰ��������Ϊwʱ������ֵ
        for(int i = 1;i <= num;i++) {
            for(int j = 1;j <= weight;j++) {
                // ��������Ʒ���������ڵ�ǰ����ʱ����ѡ��
                if(w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                // ���������ֵ�ж�
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1],
                            dp[i - 1][j]);
                }
            }
        }
        return dp[num][weight];
    }
}
