package com.bjx.bit;

/**
 * @author EnochStar
 * @title: CountingBits
 * @projectName leetcode_study
 * @description: 
 * ����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: [0,1,1]
 * ʾ�� 2:
 *
 * ����: 5
 * ���: [0,1,1,2,1,2]
 * ����:
 *
 * ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ��������
 * Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
 * ���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е� __builtin_popcount����ִ�д˲�����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/counting-bits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/27 16:00
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i <= num;i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
