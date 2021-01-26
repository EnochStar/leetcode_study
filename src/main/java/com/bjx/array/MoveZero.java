package com.bjx.array;

/**
 * @author EnochStar
 * @title: MoveZero
 * @projectName leetcode_study
 * @description:
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 *
 * ʾ��:
 *
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ˵��:
 *
 * ������ԭ�����ϲ��������ܿ�����������顣
 * �������ٲ���������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/move-zeroes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/26 16:51
 */
public class MoveZero {
    // First Way
    // public void moveZeroes(int[] nums) {
    //     int len = nums.length;
    //     int insertIdx = 0;
    //     for(int i = 0;i < len;i++) {
    //         if(nums[i] != 0) {
    //             nums[insertIdx++] = nums[i];
    //         }
    //     }
    //     while(insertIdx < len) {
    //         nums[insertIdx++] = 0;
    //     }
    // }

    //--------------------------------------------------

    // Second Way
    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
