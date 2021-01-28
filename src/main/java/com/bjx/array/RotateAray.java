package com.bjx.array;

/**
 * @author EnochStar
 * @title: RotateAray
 * @projectName leetcode_study
 * @description: 
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 *
 *  
 *
 * ���ף�
 *
 * �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣
 * �����ʹ�ÿռ临�Ӷ�Ϊ O(1) �� ԭ�� �㷨������������
 *  
 *
 * ʾ�� 1:
 *
 * ����: nums = [1,2,3,4,5,6,7], k = 3
 * ���: [5,6,7,1,2,3,4]
 * ����:
 * ������ת 1 ��: [7,1,2,3,4,5,6]
 * ������ת 2 ��: [6,7,1,2,3,4,5]
 * ������ת 3 ��: [5,6,7,1,2,3,4]
 * ʾ�� 2:
 *
 * ���룺nums = [-1,-100,3,99], k = 2
 * �����[3,99,-1,-100]
 * ����: 
 * ������ת 1 ��: [99,-1,-100,3]
 * ������ת 2 ��: [3,99,-1,-100]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rotate-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/28 20:32
 */
public class RotateAray {

    // ����һ�� ʱ�临�Ӷ�O��n�� �ռ�O(n)
    // public void rotate(int[] nums, int k) {
    //     int len = nums.length;
    //     int[] copy = new int[len];
    //     for(int i = 0;i < len;i++) {
    //         copy[(i + k)%len] = nums[i];
    //     }
    //     System.arraycopy(copy, 0, nums, 0, len);
    // }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0,nums.length - 1,nums);
        reverse(0,k - 1,nums);
        reverse(k,nums.length - 1,nums);
    }
    public void reverse(int start,int end,int[] nums) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
