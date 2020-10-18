package offer;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣
 *
 * ���������������ڵ㣬ǰ�к󣬽��е�������
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
