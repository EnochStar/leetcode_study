package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: SwapPairs
 * @projectName leetcode_study
 * @description:
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 * ���룺head = [1,2,3,4]
 * �����[2,1,4,3]
 *
 * ���룺head = []
 * �����[]
 * @date 2021/1/27 22:39
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
