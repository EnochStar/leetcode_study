package com.bjx.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *                1
 *          |      |      \
 *      3          2         4
 *     | \
 *    5    6
 *
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 */

public class N_aryTreeLevelOrderTraversal {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> levelOrder(nNode root) {
        if(root == null) {
            return res;
        }
        LinkedList<nNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> list = new ArrayList();
            while(num > 0) {
                nNode node = queue.poll();
                list.add(node.val);
                for(nNode child : node.children) {
                    queue.offer(child);
                }
                num--;
            }
            res.add(list);
        }
        return res;
    }
    // 递归
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        levelOrderDFS(root,0,res);
        return res;
    }
    public void levelOrderDFS(Node node,int depth,List<List<Integer>> res) {
        if(node == null) {
            return;
        }
        if(depth == res.size()) {
            res.add(new ArrayList());
        }
        res.get(depth).add(node.val);
        for(Node children : node.children) {
            levelOrderDFS(children,depth + 1,res);
        }
    }
}
