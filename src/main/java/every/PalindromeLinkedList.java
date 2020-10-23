package every;

/**
 * @author FL8000
 * 题目分析：请判断一个链表是否为回文链表。
 * --------------------------------------------------------------------
 * 分析：
 * 通过快慢指针的方式，确定中点位置，然后反转链表，依次比较
 * 反转链表的模板可以背下来
 */
public class PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null){
            if(slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode newNode = reverse(node.next);
        // 此处不能写为newNode.next = node; 因为当前node的next节点尚未被改变
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}
