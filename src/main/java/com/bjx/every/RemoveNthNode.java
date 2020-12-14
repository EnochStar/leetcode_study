package com.bjx.every;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
 * ------------------------------------------------------------
 * ������
 * �����������k+1�������ɣ���Ҫע����ǿ�ָ�����⡣
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            if(n==0){
                return head;
            }
            ListNode pre=new ListNode(0);
            pre.next=head;
            ListNode slow=pre;
            ListNode fast=head;
            while(fast!=null&&n-1>0){
                fast=fast.next;
                n--;
            }
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return pre.next;
        }
    }
}
