package offer;

/**
 * @author FL8000
 * 题目描述：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * ------------------------------------------------------------------------
 *
 * 分析：做好递增排序；注意鲁棒性
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
