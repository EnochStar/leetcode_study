package com.bjx.binarysearch;

/**
 * @author EnochStar
 * @title: ValidPerfectSquare
 * @projectName leetcode_study
 * @description: 
 * ����һ�������� num����дһ����������� num ��һ����ȫƽ�������򷵻� True�����򷵻� False��
 *
 * ˵������Ҫʹ���κ����õĿ⺯������  sqrt��
 *
 * ʾ�� 1��
 *
 * ���룺16
 * �����True
 * ʾ�� 2��
 *
 * ���룺14
 * �����False
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-perfect-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/21 11:12
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 0,right = num;
        while(left <= right) {
            long mid = (right - left) / 2 + left;
            if(mid * mid == num) {
                return true;
            }else if (mid * mid > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
