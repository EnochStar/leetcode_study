package com.bjx.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EnochStar
 * @title: ThreeSum
 * @projectName leetcode_study
 * @description: 
 * ����һ������ n ������������   nums���ж�   nums   ���Ƿ��������Ԫ�� a��b��c ��ʹ��   a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 *
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 *
 *    
 *
 * ʾ�� 1��
 *
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ʾ�� 2��
 *
 * ���룺nums = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺nums = [0]
 * �����[]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/3sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/26 20:05
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) return res;
            int L = i + 1;
            int R = nums.length - 1;
            while(L < R) {
                if(nums[i] + nums[L] + nums[R] == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if (nums[i] + nums[R] + nums[L] > 0) {
                    R--;
                }else{
                    L++;
                }
            }
        }
        return res;
    }
}
