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
 * ����һ�� N ������������ڵ�ֵ�ĺ��������
 *
 * ���磬����һ�� 3���� :
 *
 *  
 *
 *
 *
 *  
 *
 * ������������: [5,6,3,2,4,1].
 *
 *  
 *
 * ˵��: �ݹ鷨�ܼ򵥣������ʹ�õ�������ɴ�����?
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
    // �ݹ�
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

    // ����
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

