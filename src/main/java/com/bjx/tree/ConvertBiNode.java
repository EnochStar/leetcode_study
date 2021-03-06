package com.bjx.tree;

/**
 * @author FL8000
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 *
 * 注意循环问题，对树的左节点置null
 */
public class ConvertBiNode {
    TreeNode f;
    public TreeNode convertBiNode(TreeNode root) {
        f = new TreeNode(-1);
        TreeNode pre = f;
        dfs(root);
        return pre.right;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        // f.left = null;
        // f.right = root;
        // f = f.right;
        f.right = root;
        root.left = null;
        f = f.right;
        dfs(root.right);
    }
}
