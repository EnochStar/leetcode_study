package offer;

/**
 * @author FL8000
 * 题目描述：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *------------------------------------------------------------------------------------------------
 *
 * 分析：求倒数第k个节点。即求第n-k+1的节点。可以先将链表遍历一遍获得n的值，然后再遍历一次获得结果。
 * 也可以用双指针的方法一次遍历获取值。快指针先走k-1步，然后快慢指针一起走，当快指针到达链表尾部时，慢指针指向的就是倒数第k个节点
 * 注意空指针异常
 */
public class NumTwentyTwo {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
  }
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k-1>0&&fast!=null){
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
