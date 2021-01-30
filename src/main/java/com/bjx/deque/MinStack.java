package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: MinStack
 * @projectName leetcode_study
 * @description: 
 * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 *
 * push(x) ���� ��Ԫ�� x ����ջ�С�
 * pop()���� ɾ��ջ����Ԫ�ء�
 * top()���� ��ȡջ��Ԫ�ء�
 * getMin() ���� ����ջ�е���СԪ�ء�
 * 
 *
 * ʾ��:
 *
 * ���룺
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * �����
 * [null,null,null,null,-3,null,0,-2]
 *
 * ���ͣ�
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.getMin();   --> ���� -2.
 * 
 *
 * ��ʾ��
 *
 * pop��top �� getMin ���������� �ǿ�ջ �ϵ��á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-stack
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/30 15:00
 */
public class MinStack {
    /** initialize your data structure here. */

    Deque<Integer> deque;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x <= min) {
            deque.push(min);
            min = x;
        }
        deque.push(x);
    }

    public void pop() {
        if (deque.pop() == min)
            min = deque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return min;
    }
}
