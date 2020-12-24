package com.bjx.dp;

/**
 * @author EnochStar
 * @title: UniqueBinarySearchTrees
 * @projectName leetcode_study
 * @description:
 * ����һ������ n������ 1 ... n Ϊ�ڵ���ɵĶ����������ж����֣�
 *
 * ʾ��:
 *
 * ����: 3
 * ���: 5
 * ����:
 * ���� n = 3, һ���� 5 �ֲ�ͬ�ṹ�Ķ���������:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/unique-binary-search-trees
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/24 9:31
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= i;j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
