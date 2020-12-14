package com.bjx.tree;

/**
 * @author FL8000
 * ����һ�ö����������㷵�������������������нڵ��ֵ֮�ͣ�
 *
 * �ýڵ���游�ڵ��ֵΪż������һ���ڵ���游�ڵ���ָ�ýڵ�ĸ��ڵ�ĸ��ڵ㡣��
 * ����������游�ڵ�ֵΪż���Ľڵ㣬��ô����0 ��
 *
 * ���룺root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * �����18
 * ���ͣ�ͼ�к�ɫ�ڵ���游�ڵ��ֵΪż������ɫ�ڵ�Ϊ��Щ��ɫ�ڵ���游�ڵ㡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SumEvenGrandparent {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) {
            return sum;
        }
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.val % 2 == 0){
            add(root);
        }
        dfs(root.left);
        dfs(root.right);
    }
    public void add(TreeNode root) {
        if(root.left != null) {
            if(root.left.left != null) {
                sum += root.left.left.val;
            }
            if(root.left.right != null) {
                sum += root.left.right.val;
            }
        }
        if(root.right != null) {
            if(root.right.left != null) {
                sum += root.right.left.val;
            }
            if(root.right.right != null) {
                sum += root.right.right.val;
            }
        }
    }
}
