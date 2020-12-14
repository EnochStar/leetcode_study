package com.bjx.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author FL8000
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class ZigzagLevelOrder {
    List<List<Integer>> res = new ArrayList();
    List<Integer> temp;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            temp = new ArrayList<>();
            while(count > 0) {
                TreeNode cur = queue.poll();
                count--;
                if(res.size() % 2 == 0) {
                    temp.add(cur.val);
                }else{
                    temp.add(0,cur.val);
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
