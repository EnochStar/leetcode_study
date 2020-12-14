package com.bjx.tree;

/**
 * @author FL8000
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class PreorderToInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if(pStart > pEnd){
            return null;
        }
        int rootVal = preorder[pStart];
        int index = -1;
        for(int i = iStart;i <= iEnd;i++) {
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - iStart;
        root.left = build(preorder, pStart + 1, pStart + leftSize, inorder, iStart, index - 1);
        root.right = build(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }
}