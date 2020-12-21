package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MaximumProductSubarray
 * @projectName leetcode_study
 * @description:
 * ����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
 *
 *  
 *
 * ʾ�� 1:
 *
 * ����: [2,3,-2,4]
 * ���: 6
 * ����: ������ [2,3] �����˻� 6��
 * ʾ�� 2:
 *
 * ����: [-2,0,-1]
 * ���: 0
 * ����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-product-subarray
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/21 16:00
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);

            max = Math.max(max,imax);
        }
        return max;
    }
}
