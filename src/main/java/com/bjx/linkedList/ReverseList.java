package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: ReverseList
 * @projectName leetcode_study
 * @description:
 * ��תһ��������
 *
 * ʾ��:
 *
 * ����: 1->2->3->4->5->NULL
 * ���: 5->4->3->2->1->NULL
 * ����:
 * ����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-linked-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/27 14:23
 */
public class ReverseList {
    // ����
    // public ListNode reverseList(ListNode head) {
    //     ListNode pre = null;
    //     while(head != null) {
    //         ListNode next = head.next;
    //         head.next = pre;
    //         pre = head;
    //         head = next;
    //     }
    //     return pre;
    // }

    // �ݹ�
    public ListNode reverseList(ListNode head) {
        return reverseList(head,null);
    }
    public ListNode reverseList(ListNode head,ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next,head);
    }
}
