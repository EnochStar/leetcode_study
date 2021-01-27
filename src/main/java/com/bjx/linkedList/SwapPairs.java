package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: SwapPairs
 * @projectName leetcode_study
 * @description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = []
 * 输出：[]
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
