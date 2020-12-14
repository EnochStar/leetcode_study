package com.bjx.every;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * 题目描述：
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * -------------------------------------------------------------------
 * 分析：用线性表的方式存储链表，即可得到链表对应下标，进行处理。或者以寻找链表中点 + 链表逆序 + 合并链表的方式重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {
    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> arr = new ArrayList();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur);
            cur = cur.next;
        }
        int i = 0;
        int j = arr.size() - 1;
        while(i < j){
            arr.get(i).next = arr.get(j);
            i++;
            if(i == j){
                break;
            }
            arr.get(j).next = arr.get(i);
            j--;
        }
        arr.get(i).next = null;
    }
}
