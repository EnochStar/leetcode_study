package com.bjx.dp;

/**
 * @author EnochStar
 * @title: LongestPalindromicSubsequence
 * @projectName leetcode_study
 * @description:
 * ����һ���ַ��� s ���ҵ�������Ļ��������У������ظ����еĳ��ȡ����Լ��� s ����󳤶�Ϊ 1000 ��
 *
 *
 *
 * ʾ�� 1:
 * ����:
 *
 * "bbbab"
 * ���:
 *
 * 4
 * һ�����ܵ������������Ϊ "bbbb"��
 *
 * ʾ�� 2:
 * ����:
 *
 * "cbbd"
 * ���:
 *
 * 2
 * һ�����ܵ������������Ϊ "bb"��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/30 11:41
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        if(n == 1) return 1;
        if(n == 2) return s.charAt(0) == s.charAt(1) ? 2:1;
        for(int i = 0;i < n;i++) {
            dp[i][i] = 1;
        }
        for(int i = n - 1;i >= 0;i--) {
            for(int j = i + 1;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
