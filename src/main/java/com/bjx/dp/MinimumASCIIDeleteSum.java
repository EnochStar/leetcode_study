package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MinimumASCIIDeleteSum
 * @projectName leetcode_study
 * @description: 
 * ���������ַ���s1, s2���ҵ�ʹ�����ַ����������ɾ���ַ���ASCIIֵ����С�͡�
 *
 * ʾ�� 1:
 *
 * ����: s1 = "sea", s2 = "eat"
 * ���: 231
 * ����: �� "sea" ��ɾ�� "s" ���� "s" ��ֵ(115)�����ܺ͡�
 * �� "eat" ��ɾ�� "t" ���� 116 �����ܺ͡�
 * ����ʱ�������ַ�����ȣ�115 + 116 = 231 ���Ƿ�����������С�͡�
 * ʾ��  2:
 *
 * ����: s1 = "delete", s2 = "leet"
 * ���: 403
 * ����: �� "delete" ��ɾ�� "dee" �ַ������ "let"��
 * �� 100[d]+101[e]+101[e] �����ܺ͡��� "leet" ��ɾ�� "e" �� 101[e] �����ܺ͡�
 * ����ʱ�������ַ��������� "let"�������Ϊ 100+101+101+101 = 403 ��
 * �����Ϊ�������ַ���ת��Ϊ "lee" �� "eet"�����ǻ�õ� 433 �� 417 �Ľ�����ȴ𰸸���
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/29 13:44
 */
public class MinimumASCIIDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1;i <= len1;i++) {
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }
        for (int j = 1;j <= len2;j++) {
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }
        for (int i = 1;i <= len1;i++) {
            for (int j = 1;j <= len2;j++) {
                if (s1.charAt(i -  1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
