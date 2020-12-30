package com.bjx.dp;

/**
 * @author EnochStar
 * @title: LongestPalindromicSubstring
 * @projectName leetcode_study
 * @description:
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ���s ����󳤶�Ϊ 1000��
 *
 * ʾ�� 1��
 *
 * ����: "babad"
 * ���: "bab"
 * ע��: "aba" Ҳ��һ����Ч�𰸡�
 * ʾ�� 2��
 *
 * ����: "cbbd"
 * ���: "bb"
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-palindromic-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/30 10:05
 */
public class LongestPalindromicSubstring {
    // ˫ָ�뷨
    // public String longestPalindrome(String s) {
    //     String res = new String();
    //     for (int i = 0;i < s.length();i++) {
    //         String s1 = substring(s,i,i);
    //         String s2 = substring(s, i, i + 1);
    //         res = res.length() > s1.length()?res:s1;
    //         res = res.length() > s2.length()?res:s2;
    //     }
    //     return res;
    // }
    // public String substring(String s, int left, int right) {
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //     }
    //     return s.substring(left,right + 1);
    // }

    // ��̬�滮

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0;l < n;l++) {
            for (int i = 0;i + l < n;i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                }
                else if (l == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i,j + 1);
                }
            }
        }
        return ans;
    }
}
