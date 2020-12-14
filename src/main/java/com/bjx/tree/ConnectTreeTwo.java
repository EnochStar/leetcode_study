package com.bjx.tree;

/**
 * @author FL8000
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class ConnectTreeTwo {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        if(root.left != null) {
            if(root.right != null) {
                root.left.next=root.right;
            }else{
                root.left.next = nextNode(root);
            }
        }
        if(root.right != null) {
            root.right.next = nextNode(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node nextNode(Node root){
        while(root.next != null){
            root = root.next;
            if(root.left != null) {
                return root.left;
            }
            if(root.right != null) {
                return root.right;
            }
        }
        return null;
    }
}
