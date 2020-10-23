package every;

/**
 * @author FL8000
 * ��Ŀ���������ж�һ�������Ƿ�Ϊ��������
 * --------------------------------------------------------------------
 * ������
 * ͨ������ָ��ķ�ʽ��ȷ���е�λ�ã�Ȼ��ת�������αȽ�
 * ��ת�����ģ����Ա�����
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
        // �˴�����дΪnewNode.next = node; ��Ϊ��ǰnode��next�ڵ���δ���ı�
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}
