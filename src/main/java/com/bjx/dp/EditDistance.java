package com.bjx.dp;

/**
 * @author EnochStar
 * @title: EditDistance
 * @projectName leetcode_study
 * @description: 
 * ������������ word1 �� word2������������ word1 ת���� word2 ��ʹ�õ����ٲ����� ��
 *
 * ����Զ�һ�����ʽ����������ֲ�����
 *
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 *  
 *
 * ʾ�� 1��
 *
 * ���룺word1 = "horse", word2 = "ros"
 * �����3
 * ���ͣ�
 * horse -> rorse (�� 'h' �滻Ϊ 'r')
 * rorse -> rose (ɾ�� 'r')
 * rose -> ros (ɾ�� 'e')
 * ʾ�� 2��
 *
 * ���룺word1 = "intention", word2 = "execution"
 * �����5
 * ���ͣ�
 * intention -> inention (ɾ�� 't')
 * inention -> enention (�� 'i' �滻Ϊ 'e')
 * enention -> exention (�� 'n' �滻Ϊ 'x')
 * exention -> exection (�� 'n' �滻Ϊ 'c')
 * exection -> execution (���� 'u')
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/edit-distance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/25 11:20
 */
public class EditDistance {
    // ������¼��DP
    int[][] memo;
    public int minDistanceDPMemory(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return dp(word1, word2, word1.length() - 1, word2.length() - 1);
    }
    public int dp(String word1, String word2, int index1, int index2) {
        if(index1 == -1) {
            return index2 + 1;
        }
        if(index2 == -1) {
            return index1 + 1;
        }
        if(memo[index1][index2] != 0) {
            return memo[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = dp(word1, word2, index1 - 1,index2 - 1);
            return memo[index1][index2];
        }
        memo[index1][index2] = Math.min(dp(word1,word2,index1 - 1,index2) + 1,
                Math.min(dp(word1,word2,index1 - 1,index2 - 1),dp(word1,word2,index1,index2 - 1)) + 1);
        return memo[index1][index2];
    }

    // �Ե����� DP Table
    public int minDistanceDPTable(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1;i <= len1;i++) {
            dp[i][0] = i;
        }
        for(int j = 1;j <= len2;j++) {
            dp[0][j] = j;
        }
        for(int i = 1;i <= len1;i++) {
            for(int j = 1;j <= len2;j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i][j - 1])) + 1;
            }
        }
        return dp[len1][len2];
    }
}
