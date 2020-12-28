package com.bjx.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author EnochStar
 * @title: RussianDollEnvelopes
 * @projectName leetcode_study
 * @description: 
 * ����һЩ����˿�Ⱥ͸߶ȵ��ŷ⣬��Ⱥ͸߶�����������ʽ  (w, h)  ���֡�����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ������ŷ�Ϳ��ԷŽ���һ���ŷ����ͬ����˹����һ����
 *
 * �����������ж��ٸ��ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ����棩��
 *
 * ˵��:
 * ��������ת�ŷ⡣
 *
 * ʾ��:
 *
 * ����: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * ���: 3 
 * ����: ����ŷ�ĸ���Ϊ 3, ���Ϊ: [2,3] => [5,4] => [6,7]��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/russian-doll-envelopes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/28 14:56
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // ��ά���� �����뽵��
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0;i < n;i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
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
