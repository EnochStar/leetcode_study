package offer;

/**
 * @author FL8000
 * ��Ŀ����������������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ�������ġ�
 *
 * ------------------------------------------------------------------------
 *
 * ���������õ�������ע��³����
 *
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class NumTwentyFive {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur = null;
        if(l1.val < l2.val){
            cur = l1;
            cur.next = mergeTwoLists(l1.next, l2);
        }else{
            cur = l2;
            cur.next = mergeTwoLists(l1, l2.next);
        }
        return cur;
    }
}
