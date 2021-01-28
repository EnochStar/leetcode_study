package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: MergeTwoLists
 * @projectName leetcode_study
 * @description: 
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
 *
 *  
 *
 * ʾ�� 1��
 *
 *
 * ���룺l1 = [1,2,4], l2 = [1,3,4]
 * �����[1,1,2,3,4,4]
 * ʾ�� 2��
 *
 * ���룺l1 = [], l2 = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺l1 = [], l2 = [0]
 * �����[0]
 *  
 *
 * ��ʾ��
 *
 * ��������Ľڵ���Ŀ��Χ�� [0, 50]
 * -100 <= Node.val <= 100
 * l1 �� l2 ���� �ǵݼ�˳�� ����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-two-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/28 20:36
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }
}
