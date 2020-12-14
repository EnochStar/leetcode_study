package com.bjx.tree;

/**
 * @author FL8000
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leave
 */
public class SumofLeftLeaves {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        inorder(root);
        return res;
    }
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        inorder(root.left);
        inorder(root.right);
    }
}
