package com.bjx.linkedList;

/**
 * @author EnochStar
 * @title: ReverseList
 * @projectName leetcode_study
 * @description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/27 14:23
 */
public class ReverseList {
    // 迭代
    // public ListNode reverseList(ListNode head) {
    //     ListNode pre = null;
    //     while(head != null) {
    //         ListNode next = head.next;
    //         head.next = pre;
    //         pre = head;
    //         head = next;
    //     }
    //     return pre;
    // }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
