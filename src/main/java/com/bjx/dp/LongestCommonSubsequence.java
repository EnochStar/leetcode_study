package com.bjx.dp;

/**
 * @author EnochStar
 * @title: LongestCommonSubsequence
 * @projectName leetcode_study
 * @description: 
 * ���������ַ��� text1 �� text2�������������ַ���������������еĳ��ȡ�
 *
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С������ַ����ġ����������С����������ַ�������ͬӵ�е������С�
 *
 * ���������ַ���û�й��������У��򷵻� 0��
 *
 *
 * ʾ�� 1:
 *
 * ���룺text1 = "abcde", text2 = "ace" 
 * �����3  
 * ���ͣ�������������� "ace"�����ĳ���Ϊ 3��
 * ʾ�� 2:
 *
 * ���룺text1 = "abc", text2 = "abc"
 * �����3
 * ���ͣ�������������� "abc"�����ĳ���Ϊ 3��
 * ʾ�� 3:
 *
 * ���룺text1 = "abc", text2 = "def"
 * �����0
 * ���ͣ������ַ���û�й��������У����� 0��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-common-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/18 20:34
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m;i++) {
            for(int j = 1; j <= n;j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
