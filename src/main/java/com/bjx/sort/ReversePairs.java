package com.bjx.sort;

/**
 * @author EnochStar
 * @title: ReversePairs
 * @projectName leetcode_study
 * @description: 
 * ����һ������ nums ����� i < j �� nums[i] > 2*nums[j] ���Ǿͽ� (i, j) ����һ����Ҫ��ת�ԡ�
 *
 * ����Ҫ���ظ��������е���Ҫ��ת�Ե�������
 *
 * ʾ�� 1:
 *
 * ����: [1,3,2,3,1]
 * ���: 2
 * ʾ�� 2:
 *
 * ����: [2,4,3,5,1]
 * ���: 3
 * ע��:
 *
 * ��������ĳ��Ȳ��ᳬ��50000��
 * ���������е��������ֶ���32λ�����ı�ʾ��Χ�ڡ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/3/2 15:18
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums,0,nums.length - 1);
    }
    public int mergeSort(int[] nums,int left,int right) {
        if(right <= left) return 0;
        int mid = (left + right) >> 1;
        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid + 1,right);
        int i = left,t = left,c = 0;
        int[] cache = new int[right - left + 1];
        for(int j = mid + 1;j <= right;j++,c++) {
            while(i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while(t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            count += mid - i + 1;
            cache[c] = nums[j];
        }
        while(t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache,0,nums,left,right - left + 1);
        return count;
    }
}
