package com.bjx.tree;

/**
 * @author EnochStar
 * @title: SearchBST
 * @projectName leetcode_study
 * @description:
 * ����������������BST���ĸ��ڵ��һ��ֵ�� ����Ҫ��BST���ҵ��ڵ�ֵ���ڸ���ֵ�Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� NULL��
 *
 * ���磬
 *
 * ��������������:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * ��ֵ: 2
 * ��Ӧ�÷�����������:
 *
 *       2
 *      / \
 *     1   3
 * ������ʾ���У����Ҫ�ҵ�ֵ�� 5������Ϊû�нڵ�ֵΪ 5������Ӧ�÷��� NULL��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/1014:25
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        else if(root.val > val) {
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }
}
