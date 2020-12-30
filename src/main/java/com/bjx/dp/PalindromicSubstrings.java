package com.bjx.dp;

/**
 * @author EnochStar
 * @title: PalindromicSubstrings
 * @projectName leetcode_study
 * @description: ����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
 * <p>
 * ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺"abc"
 * �����3
 * ���ͣ����������Ӵ�: "a", "b", "c"
 * ʾ�� 2��
 * <p>
 * ���룺"aaa"
 * �����6
 * ���ͣ�6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/palindromic-substrings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/30 10:48
 */
public class PalindromicSubstrings {
    // ˫ָ�뷨
    // public int countSubstrings(String s) {
    //     int sum = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         int count1 = substring(s, i, i);
    //         int count2 = substring(s, i, i + 1);
    //         sum = sum + count1 + count2;
    //     }
    //     return sum;
    // }
    //
    // public int substring(String s, int left, int right) {
    //     int count = 0;
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //         count++;
    //     }
    //     return count;
    // }

    // ��̬�滮

    public int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int l = 0;l < n;l++) {
            for(int i = 0;i + l < n;i++) {
                int j = i + l;
                if(l == 0) {
                    dp[i][j] = true;
                    count++;
                }else if(l == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if(dp[i][j]) count++;
                }
            }
        }
        return count;
    }

}
