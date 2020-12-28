package com.bjx.dp;

import java.util.Arrays;

/**
 * @author EnochStar
 * @title: LongestIncreasingSubsequence
 * @projectName leetcode_study
 * @description: 
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 *
 * ���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 *
 *  
 * ʾ�� 1��
 *
 * ���룺nums = [10,9,2,5,3,7,101,18]
 * �����4
 * ���ͣ�������������� [2,3,7,101]����˳���Ϊ 4 ��
 * ʾ�� 2��
 *
 * ���룺nums = [0,1,0,3,2,3]
 * �����4
 * ʾ�� 3��
 *
 * ���룺nums = [7,7,7,7,7,7,7]
 * �����1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-increasing-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/28 14:39
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i = 1;i < nums.length;i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    min = Math.max(min, dp[j]);
                }
            }
            dp[i] = min < dp[i]?dp[i]:min+1;
            max = dp[i] > max?dp[i]:max;
        }
        return max;
    }
}
