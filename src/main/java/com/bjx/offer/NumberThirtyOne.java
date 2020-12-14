package com.bjx.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FL8000
 * ��Ŀ���������������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ���磬���� {1,2,3,4,5} ��ĳջ��ѹջ���У����� {4,5,3,2,1} �Ǹ�ѹջ���ж�Ӧ��һ���������У��� {4,3,5,1,2} �Ͳ������Ǹ�ѹջ���еĵ������С�
 *
 * ---------------------------------------------------------------------------------------------
 * �������ޡ�
 */
public class NumberThirtyOne {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();
        int j = 0;
        for(int elem : pushed){
            stack.push(elem);
            while(j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
