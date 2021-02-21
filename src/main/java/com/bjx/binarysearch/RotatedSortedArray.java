package com.bjx.binarysearch;

/**
 * @author EnochStar
 * @title: RotatedSortedArray
 * @projectName leetcode_study
 * @description: 
 * �������е��������� nums ��Ԥ��δ֪��ĳ�����Ͻ�������ת�����磬 [0,1,2,4,5,6,7] ����ת����ܱ�Ϊ [4,5,6,7,0,1,2] ����
 *
 * ���������������� target ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,5,6,7,0,1,2], target = 0
 * �����4
 * ʾ�� 2��
 *
 * ���룺nums = [4,5,6,7,0,1,2], target = 3
 * �����-1
 * ʾ�� 3��
 *
 * ���룺nums = [1], target = 0
 * �����-1
 *  
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums �е�ÿ��ֵ�� ��һ�޶�
 * nums �϶�����ĳ��������ת
 * -10^4 <= target <= 10^4
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/21 12:10
 */
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[left]) {
                if(target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
