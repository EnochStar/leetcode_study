package com.bjx.dp;

/**
 * @author EnochStar
 * @title: HouseRobber
 * @projectName leetcode_study
 * @description: 
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺[1,2,3,1]
 * �����4
 * ���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
 *       ͵�Ե�����߽�� = 1 + 3 = 4 ��
 * ʾ�� 2��
 *
 * ���룺[2,7,9,3,1]
 * �����12
 * ���ͣ�͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
 *      ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/house-robber
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/21 16:38
 */
public class HouseRobber {
    public int rob(int[] nums) {
        // 1��������
        // 2��״̬����
        // 3��DP����
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        if(len == 3) {
            return Math.max(dp[2],nums[1]);
        }
        for(int i = 3;i < len;i++) {
            dp[i] = Math.max(dp[i - 2],dp[i - 3]) + nums[i];
        }
        return Math.max(dp[len - 1],dp[len - 2]);
    }
}
