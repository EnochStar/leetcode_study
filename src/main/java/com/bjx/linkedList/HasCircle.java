package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: HasCircle
 * @projectName leetcode_study
 * @description: 
 * ����һ�������ж��������Ƿ��л���
 *
 * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
 *
 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 *
 * ���룺head = [3,2,0,-4], pos = 1
 * �����true
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *     
 *
 * ���ף�
 *
 * ������ O(1)�������������ڴ�����������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/27 22:53
 */
public class HasCircle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
