package com.bjx.bit;

/**
 * @author EnochStar
 * @title: ReverseBits
 * @projectName leetcode_study
 * @description: 
 * �ߵ������� 32 λ�޷��������Ķ�����λ��
 *
 *  
 *
 * ʾ�� 1��
 *
 * ����: 00000010100101000001111010011100
 * ���: 00111001011110000010100101000000
 * ����: ����Ķ����ƴ� 00000010100101000001111010011100 ��ʾ�޷������� 43261596��
 *      ��˷��� 964176192��������Ʊ�ʾ��ʽΪ 00111001011110000010100101000000��
 * ʾ�� 2��
 *
 * ���룺11111111111111111111111111111101
 * �����10111111111111111111111111111111
 * ���ͣ�����Ķ����ƴ� 11111111111111111111111111111101 ��ʾ�޷������� 4294967293��
 *      ��˷��� 3221225471 ������Ʊ�ʾ��ʽΪ 10111111111111111111111111111111 ��
 *  
 *
 * ��ʾ��
 *
 * ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
 * �� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ�������� ʾ�� 2 �У������ʾ�з������� -3�������ʾ�з������� -1073741825��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-bits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/27 15:34
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int a = 0;
        for(int i = 0;i <= 31;i++) {
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }
}