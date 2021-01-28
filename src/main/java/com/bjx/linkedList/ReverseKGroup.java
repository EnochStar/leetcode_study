package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: ReverseKGroup
 * @projectName leetcode_study
 * @description: 
 * ����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 *  
 *
 * ʾ����
 *
 * �����������1->2->3->4->5
 *
 * �� k = 2 ʱ��Ӧ������: 2->1->4->3->5
 *
 * �� k = 3 ʱ��Ӧ������: 3->2->1->4->5
 *
 *  
 *
 * ˵����
 *
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/28 16:21
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
