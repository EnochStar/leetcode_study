package com.bjx.bit;

/**
 * @author EnochStar
 * @title: PowerofTwo
 * @projectName leetcode_study
 * @description: 
 * ����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���
 *
 * ʾ�� 1:
 *
 * ����: 1
 * ���: true
 * ����: 20 = 1
 * ʾ�� 2:
 *
 * ����: 16
 * ���: true
 * ����: 24 = 16
 * ʾ�� 3:
 *
 * ����: 218
 * ���: false
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/power-of-two
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/27 15:25
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1) )== 0;
    }
}
