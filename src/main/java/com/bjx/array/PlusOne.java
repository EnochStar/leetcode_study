package com.bjx.array;

/**
 * @author EnochStar
 * @title: PlusOne
 * @projectName leetcode_study
 * @description:
 * ����һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
 *
 * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
 *
 * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺digits = [1,2,3]
 * �����[1,2,4]
 * ���ͣ����������ʾ���� 123��
 * ʾ�� 2��
 *
 * ���룺digits = [4,3,2,1]
 * �����[4,3,2,2]
 * ���ͣ����������ʾ���� 4321��
 * ʾ�� 3��
 *
 * ���룺digits = [0]
 * �����[1]
 *  
 *
 * ��ʾ��
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/plus-one
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/29 22:56
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1;i >= 0;i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }
}
