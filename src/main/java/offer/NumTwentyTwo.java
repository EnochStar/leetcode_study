package offer;

/**
 * @author FL8000
 * ��Ŀ����������һ����������������е�����k���ڵ㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ�������������β�ڵ��ǵ�����1���ڵ㡣
 * ���磬һ��������6���ڵ㣬��ͷ�ڵ㿪ʼ�����ǵ�ֵ������1��2��3��4��5��6���������ĵ�����3���ڵ���ֵΪ4�Ľڵ㡣
 *
 *------------------------------------------------------------------------------------------------
 *
 * ������������k���ڵ㡣�����n-k+1�Ľڵ㡣�����Ƚ��������һ����n��ֵ��Ȼ���ٱ���һ�λ�ý����
 * Ҳ������˫ָ��ķ���һ�α�����ȡֵ����ָ������k-1����Ȼ�����ָ��һ���ߣ�����ָ�뵽������β��ʱ����ָ��ָ��ľ��ǵ�����k���ڵ�
 * ע���ָ���쳣
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
