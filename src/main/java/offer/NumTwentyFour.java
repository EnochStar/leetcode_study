package offer;

/**
 * @author FL8000
 * 题目描述：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 分析：建立三个节点，前中后，进行迭代处理
 *
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class NumTwentyFour {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null){
                return null;
            }
            ListNode dummy=null;
            ListNode cur=head;
            ListNode next=cur.next;
            while(next!=null){
                cur.next=dummy;
                dummy=cur;
                cur=next;
                next=next.next;
            }
            cur.next=dummy;
            return cur;
        }
    }
}
