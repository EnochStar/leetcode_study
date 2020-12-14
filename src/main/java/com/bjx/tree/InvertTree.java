package com.bjx.tree;

/**
 * @author FL8000
 * 题目:
 * 翻转一棵二叉树。
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }
};
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
