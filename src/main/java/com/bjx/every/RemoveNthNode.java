package com.bjx.every;

/**
 * @author FL8000
 * 题目描述：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * ------------------------------------------------------------
 * 分析：
 * 先求出倒数第k+1个数即可，需要注意的是空指针问题。
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
