package every;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FL8000
 * 题目描述：
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next指针都被设置为 NULL。
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *----------------------------------------------------------
 *
 * 分析：
 * 题意是在同一层次中，从左往右建立next指针，直到null为止
 * 因此很容易想到层次遍历树的方式
 *
 * 第二种思路是，利用题目提供的next指针建立连接。以每一层的最左节点作为头节点，每一层内部向右遍历，层外向左遍历
 *
 */
public class Number116 {
    public Node connect(Node root) {
        //空指针判断
        if(root==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        //queue非空判断
        while(!queue.isEmpty()){
            //读取当前时刻队列中的值
            int count=queue.size();
            //用temp存储当前队列头的值并出队
            Node temp=queue.poll();
            count--;
            while(count>0){
                //读取当前时刻队列的头,顺序不能改变
                Node cur=queue.poll();
                //将temp的左右节点读入queue中
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