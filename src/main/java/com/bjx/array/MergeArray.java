package com.bjx.array;

/**
 * @author EnochStar
 * @title: MergeArray
 * @projectName leetcode_study
 * @description: 
 * �������������������� nums1 �� nums2�����㽫 nums2 �ϲ��� nums1 �У�ʹ nums1 ��Ϊһ���������顣
 *
 * ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n ������Լ��� nums1 �Ŀռ��С���� m + n�������������㹻�Ŀռ䱣������ nums2 ��Ԫ�ء�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/29 22:30
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while(m > 0 && n > 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n > 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
