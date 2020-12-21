package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MaximumSubarray
 * @projectName leetcode_study
 * @description: 
 * ����һ���������� nums   ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ʾ��:
 *
 * ����: [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 * ����:   ����������   [4,-1,2,1] �ĺ����Ϊ   6��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-subarray
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/21 15:24
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for(int i = 1;i < nums.length;i++) {
            if(sum < 0) sum = 0;
            sum += nums[i];
            if(sum > max) max = sum;
        }
        return max;
    }
}
