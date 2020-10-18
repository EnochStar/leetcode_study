package every;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ��������������������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣
 * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
 * ��ʼ״̬�£�����nextָ�붼������Ϊ NULL��
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *----------------------------------------------------------
 *
 * ������
 * ��������ͬһ����У��������ҽ���nextָ�룬ֱ��nullΪֹ
 * ��˺������뵽��α������ķ�ʽ
 *
 * �ڶ���˼·�ǣ�������Ŀ�ṩ��nextָ�뽨�����ӡ���ÿһ�������ڵ���Ϊͷ�ڵ㣬ÿһ���ڲ����ұ����������������
 *
 */
public class Number116 {
    public Node connect(Node root) {
        //��ָ���ж�
        if(root==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        //queue�ǿ��ж�
        while(!queue.isEmpty()){
            //��ȡ��ǰʱ�̶����е�ֵ
            int count=queue.size();
            //��temp�洢��ǰ����ͷ��ֵ������
            Node temp=queue.poll();
            count--;
            while(count>0){
                //��ȡ��ǰʱ�̶��е�ͷ,˳���ܸı�
                Node cur=queue.poll();
                //��temp�����ҽڵ����queue��
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                temp.next=cur;
                temp=cur;
                count--;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        return root;
    }
    public Node connect1(Node root) {
        if(root==null){
            return null;
        }
        Node leftNode=root;
        while(leftNode.left!=null){
            Node head=leftNode;
            while(head!=null){
                head.left.next=head.right;
                if (head.next!=null){
                    head.right=head.next.left;
                }
                head=head.next;
            }
            leftNode=leftNode.left;
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};