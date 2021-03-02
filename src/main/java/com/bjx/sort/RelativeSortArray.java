package com.bjx.sort;

/**
 * @author EnochStar
 * @title: RelativeSortArray
 * @projectName leetcode_study
 * @description: 
 * �����������飬arr1 �� arr2��
 *
 * arr2 �е�Ԫ�ظ�����ͬ
 * arr2 �е�ÿ��Ԫ�ض������� arr1 ��
 * �� arr1 �е�Ԫ�ؽ�������ʹ arr1 ��������˳��� arr2 �е����˳����ͬ��δ�� arr2 �г��ֹ���Ԫ����Ҫ����������� arr1 ��ĩβ��
 *
 *  
 *
 * ʾ����
 *
 * ���룺arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * �����[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * ��ʾ��
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 �е�Ԫ�� arr2[i] ������ͬ
 * arr2 �е�ÿ��Ԫ�� arr2[i] �������� arr1 ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/relative-sort-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/3/2 14:47
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] res = new int[arr1.length];
        int index = 0;
        for(int i : arr1) {
            bucket[i]++;
        }
        for(int i : arr2) {
            while(bucket[i] > 0) {
                res[index++] = i;
                bucket[i]--;
            }
        }
        for(int i = 0;i < bucket.length;i++) {
            while(bucket[i] > 0) {
                res[index++] = i;
                bucket[i]--;
            }
        }
        return res;
    }
}
