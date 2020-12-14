package com.bjx.bfs;



import com.bjx.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author EnochStar
 * @title: MinDepthBinaryTree
 * @projectName leetcode_study
 * @description:
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/14 8:57
 */
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0;i < sz;i++) {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null) {
                    return depth;
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
