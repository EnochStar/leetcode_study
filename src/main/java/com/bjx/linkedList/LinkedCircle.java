package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: LinkedCircle
 * @projectName leetcode_study
 * @description: 
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣     ��������޻����򷵻�     null��
 *
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣬pos ���������ڱ�ʶ�����������������Ϊ�������ݵ������С�
 *
 * ˵�����������޸ĸ���������
 *
 * ���ף�
 *
 * ���Ƿ����ʹ�� O(1) �ռ������⣿
 *      
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/28 16:15
 */
public class LinkedCircle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
