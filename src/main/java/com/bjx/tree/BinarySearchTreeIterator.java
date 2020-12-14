package com.bjx.tree;

import java.util.Stack;

/**
 * @author FL8000
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ---------------------------------------------------------------------------------------------
 * 难点在于O（h） 空间复杂度的要求。
 *
 */
public class BinarySearchTreeIterator {
    /*List<com.zx.TreeNode> list = new ArrayList();
    int index = 0;
    // 中序遍历 从低到高
    public BinarySearchTreeIterator(com.zx.TreeNode root) {
        traverse(root);
    }
    public void traverse(com.zx.TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        list.add(root);
        traverse(root.right);
        return;
    }

    *//** @return the next smallest number *//*
    public int next() {
        if(hasNext()) {
            int ans = list.get(index).val;
            index++;
            return ans;
        }else{
            return -1;
        }
    }

    *//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
        if(index+1 > list.size()) {
            return false;
        }else{
            return true;
        }
    }*/

    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        leftmostInorder(root);
    }
    private void leftmostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        if (node.right != null) {
            leftmostInorder(node.right);
        }
        return ans;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
