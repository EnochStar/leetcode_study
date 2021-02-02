package com.bjx.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author FL8000
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *          1
 *    3     2      4
 * 5    6
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 */

class nNode {
    public int val;
    public List<nNode> children;

    public nNode() {}

    public nNode(int _val) {
        val = _val;
    }

    public nNode(int _val, List<nNode> _children) {
        val = _val;
        children = _children;
    }
};
public class NaryTreePreorderTraversal {
    List<Integer> list = new ArrayList();
    public List<Integer> preorder(nNode root) {
        if(root == null)
            return list;
        list.add(root.val);
        for(nNode node : root.children){
            preorder(node);
        }
        return list;
    }
    // 迭代
    // List<Integer> list = new ArrayList();
    // public List<Integer> preorder(Node root) {
    //     if(root == null) {
    //         return list;
    //     }
    //     Stack<Node> stack = new Stack();
    //     stack.add(root);
    //     while(!stack.isEmpty()) {
    //         Node nodes = stack.pop();
    //         list.add(nodes.val);
    //         for(int i = nodes.children.size() - 1;i >= 0;i--) {
    //             stack.add(nodes.children.get(i));
    //         }
    //     }
    //     return list;
    // }
}
