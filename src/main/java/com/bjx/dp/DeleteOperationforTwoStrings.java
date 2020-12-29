package com.bjx.dp;

/**
 * @author EnochStar
 * @title: DeleteOperationforTwoStrings
 * @projectName leetcode_study
 * @description: 
 * ������������ word1 �� word2���ҵ�ʹ�� word1 �� word2 ��ͬ�������С������ÿ������ɾ������һ���ַ����е�һ���ַ���
 *
 *  
 *
 * ʾ����
 *
 * ����: "sea", "eat"
 * ���: 2
 * ����: ��һ����"sea"��Ϊ"ea"���ڶ�����"eat"��Ϊ"ea"
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/29 13:29
 */
public class DeleteOperationforTwoStrings {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1;i <= len1;i++) {
            for (int j = 1;j <= len2;j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        int sum = len1 + len2 - 2 * dp[len1][len2];
        return sum;
    }
}
