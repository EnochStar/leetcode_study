package com.bjx.every;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ��������L��L0��L1������Ln-1��Ln ��
 * �����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
 *
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * -------------------------------------------------------------------
 * �����������Ա�ķ�ʽ�洢�������ɵõ������Ӧ�±꣬���д���������Ѱ�������е� + �������� + �ϲ�����ķ�ʽ��������
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
