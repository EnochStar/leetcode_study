package com.bjx.dp;

/**
 * @author EnochStar
 * @title: DivisorGame
 * @projectName leetcode_study
 * @description: 
 * ����˿�ͱ���һ������Ϸ�����������ж�������˿���ֿ��֡�
 *
 * ������ڰ�����һ������  N  ����ÿ����ҵĻغϣ������Ҫִ�����²�����
 *
 * ѡ����һ  x������  0 < x < N ��  N % x == 0  ��
 * �� N - x  �滻�ڰ��ϵ����� N ��
 * �������޷�ִ����Щ�������ͻ������Ϸ��
 *
 * ֻ���ڰ���˿����Ϸ��ȡ��ʤ��ʱ�ŷ���  True�����򷵻� False������������Ҷ������״̬������Ϸ��
 *
 *   
 *
 * ʾ�� 1��
 *
 * ���룺2
 * �����true
 * ���ͣ�����˿ѡ�� 1�������޷����в�����
 * ʾ�� 2��
 *
 * ���룺3
 * �����false
 * ���ͣ�����˿ѡ�� 1������Ҳѡ�� 1��Ȼ����˿�޷����в�����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/divisor-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/23 9:40
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
