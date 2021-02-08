package com.bjx.tree;

/**
 * @author EnochStar
 * @title: deleteNodeBST
 * @projectName leetcode_study
 * @description: 
 * ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 *
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 *
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 * ˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ O(h)��h Ϊ���ĸ߶ȡ�
 *
 * ʾ��:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * ������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������
 *
 * һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * ��һ����ȷ���� [5,2,6,null,4,null,7]��
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/delete-node-in-a-bst
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/8 17:20
 */
public class deleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        //���� ��ɾ
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }else if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    public TreeNode getMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
