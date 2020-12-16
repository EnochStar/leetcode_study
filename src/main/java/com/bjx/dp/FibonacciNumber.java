package com.bjx.dp;

/**
 * @author EnochStar
 * @title: FibonacciNumber
 * @projectName leetcode_study
 * @description: 
 * 쳲���������ͨ���� F(n) ��ʾ���γɵ����г�Ϊ쳲��������С��������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), ���� N > 1.
 * ���� N������ F(N)��
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺2
 * �����1
 * ���ͣ�F(2) = F(1) + F(0) = 1 + 0 = 1.
 * ʾ�� 2��
 *
 * ���룺3
 * �����2
 * ���ͣ�F(3) = F(2) + F(1) = 1 + 1 = 2.
 * ʾ�� 3��
 *
 * ���룺4
 * �����3
 * ���ͣ�F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/fibonacci-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/16 17:40
 */
public class FibonacciNumber {
    public int fib(int n) {
        // ����1 �Զ����� ��������ظ���
        // if(n == 0) return 0;
        // if(n == 1) return 1;
        // return fib(n-1) + fib(n-2);

        // ����2 ���ñ���¼
        //     int[] rem = new int[n + 1];
        //     return help(rem,n);
        // }
        // int help(int[] rem,int n) {
        //     if(n == 0) return 0;
        //     if(n == 1) return 1;
        //     if(rem[n] != 0) return rem[n];
        //     rem[n] = help(rem, n-1) + help(rem, n - 2);
        //     return rem[n];
        // }

        // ����3 ����״̬ת�Ʒ����γɵ�dp����
        if(n == 0) return 0;
        if(n == 1) return 1;
        int pre = 0;
        int cur = 1;
        int sum = 0;
        for(int i = 2;i <= n;i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
