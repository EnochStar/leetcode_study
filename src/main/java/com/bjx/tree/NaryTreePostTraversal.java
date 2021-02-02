package com.bjx.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author EnochStar
 * @title: NarayTreePostTraversal
 * @projectName leetcode_study
 * @description:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/2 10:38
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class NaryTreePostTraversal {
    // 递归
    List<Integer> list = new ArrayList();
    // public List<Integer> postorder(Node root) {
    //     if(root == null) {
    //         return list;
    //     }
    //     for(Node node : root.children) {
    //         postorder(node);
    //     }
    //     list.add(root.val);
    //     return list;
    // }

    // 迭代
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()) {
            Node roots = stack.pop();
            list.add(roots.val);
            for(Node node : roots.children) {
                stack.add(node);
            }
        }
        Collections.reverse(list);
        return list;
    }
}

