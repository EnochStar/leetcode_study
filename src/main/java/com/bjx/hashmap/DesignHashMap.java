package com.bjx.hashmap;

/**
 * @author FL8000
 * ������Ӧ�ð������µĹ��ܣ�
 * add(value)�����ϣ�����в���һ��ֵ��
 * contains(value) �����ع�ϣ�������Ƿ�������ֵ��
 * remove(value)��������ֵ�ӹ�ϣ������ɾ���������ϣ������û�����ֵ��ʲôҲ������
 *
 * ע�⣺���е�ֵ���� [0, 1000000]�ķ�Χ�ڡ�
 * ����������Ŀ��[1, 10000]��Χ�ڡ�
 * ��Ҫʹ���ڽ��Ĺ�ϣ���Ͽ⡣
 *
 * -------------------------------------------------
 * ������HashMap�ײ����ݽṹ�Ǻ�������������顣
 * ���������������򵥻�hashmap��ʵ��
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
