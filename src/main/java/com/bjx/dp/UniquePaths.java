package com.bjx.dp;

/**
 * @author EnochStar
 * @title: UniquePaths
 * @projectName leetcode_study
 * @description:
 * һ��������λ��һ�� m x n?��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 *
 * ���ܹ��ж�������ͬ��·����
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺m = 3, n = 7
 * �����28
 * ʾ�� 2��
 *
 * ���룺m = 3, n = 2
 * �����3
 * ���ͣ�
 * �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
 * 1. ���� -> ���� -> ����
 * 2. ���� -> ���� -> ����
 * 3. ���� -> ���� -> ����
 * ʾ�� 3��
 *
 * ���룺m = 7, n = 3
 * �����28
 * ʾ�� 4��
 *
 * ���룺m = 3, n = 3
 * �����6
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/unique-paths
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/18 19:36
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else if(i == 0) {
                    dp[i][j] = dp[i][j - 1];
                }else if(j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
