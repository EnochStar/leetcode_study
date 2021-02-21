package com.bjx.binarysearch;

/**
 * @author EnochStar
 * @title: Sqrtx
 * @projectName leetcode_study
 * @description: 
 * ʵ�� int sqrt(int x) ������
 *
 * ���㲢���� x ��ƽ���������� x �ǷǸ�������
 *
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 *
 * ʾ�� 1:
 *
 * ����: 4
 * ���: 2
 * ʾ�� 2:
 *
 * ����: 8
 * ���: 2
 * ˵��: 8 ��ƽ������ 2.82842..., 
 *      ���ڷ���������������С�����ֽ�����ȥ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sqrtx
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/21 11:13
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int left = 1,right = x;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(mid * mid > x) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
