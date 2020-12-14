package com.bjx.hashmap;

/**
 * @author FL8000
 * 你的设计应该包含以下的功能：
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 注意：所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * -------------------------------------------------
 * 分析：HashMap底层数据结构是红黑树，链表，数组。
 * 这题用链表和数组简单化hashmap的实现
 *
 * https://leetcode-cn.com/problems/design-hashset/solution/
 */
public class DesignHashMap {
    private int size=1000;
    private ListNode[] arr;
    private int index;
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    /** Initialize your data structure here. */
    public DesignHashMap() {
        arr=new ListNode[size];
    }

    public void add(int key) {
        index=key%100;
        if(contains(key)){
            return;
        }
        if(arr[index]==null){
            arr[index]=new ListNode(key);
        }else{
            ListNode cur=arr[index];
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=new ListNode(key);
        }
    }

    public void remove(int key) {
        index=key%100;
        if(arr[index]==null){
            return;
        }
        ListNode head=arr[index];
        if(head.val==key){
            arr[index]=head.next;
            head.next=null;
        }else{
            ListNode pre=head;
            ListNode cur=head.next;
            while(cur!=null){
                if(cur.val==key){
                    pre.next=cur.next;
                    cur.next=null;
                    return;
                }
                pre=cur;
                cur=cur.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        index=key%100;
        ListNode head=arr[index];
        while(head!=null){
            if(head.val==key){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
