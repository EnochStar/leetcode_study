package com.bjx.backtrack;

/**
 * @author EnochStar
 * @title: IsAdditiveNumber
 * @projectName leetcode_study
 * @description: �ۼ�����һ���ַ���������������ֿ����γ��ۼ����С�
 *
 * һ����Ч���ۼ����б������ٰ��� 3 �����������ʼ�����������⣬�ַ����е���������������֮ǰ��������ӵĺ͡�
 *
 * ����һ��ֻ�������� '0'-'9' ���ַ�������дһ���㷨���жϸ��������Ƿ����ۼ�����
 *
 * ˵��: �ۼ���������������� 0 ��ͷ�����Բ������ 1, 2, 03 ���� 1, 02, 3 �������
 *
 * ʾ�� 1:
 *
 * ����: "112358"
 * ���: true 
 * ����: �ۼ�����Ϊ: 1, 1, 2, 3, 5, 8 ��1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * ʾ��2:
 *
 * ����: "199100199"
 * ���: true 
 * ����: �ۼ�����Ϊ: 1, 99, 100, 199��1 + 99 = 100, 99 + 100 = 199
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/additive-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ������ ��֦�� 1��λ�����ڶ�����һλΪ0�ļ�֦ 2����ȡ��ĩβ��k��ֵС��2  3���������ֲ�������ǰ��������ӵĺ�
 * @date 2020/12/716:23
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return backtrack(num,num.length(),0,0,0,0);
    }
    boolean backtrack(String num, int len, int idx, long pre, long sum, int k) {
        if(idx == len) {
            return k > 2;
        }
        for(int i = idx; i < len; i++) {
            long cur = fetchNum(num,idx,i);
            if(cur < 0) continue;
            if(k >= 2 && cur != sum) continue;
            if(backtrack(num,len,i + 1,cur, pre + cur, k + 1)){
                return true;
            }
        }
        return false;
    }
    long fetchNum(String num, int left, int right) {
        if(left < right && num.charAt(left) == '0') return -1;
        long res = 0;
        while(left <= right) {
            res = res * 10 + num.charAt(left) - '0';
            left++;
        }
        return res;
    }
}
