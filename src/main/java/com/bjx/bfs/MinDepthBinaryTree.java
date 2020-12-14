package com.bjx.bfs;



import com.bjx.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author EnochStar
 * @title: MinDepthBinaryTree
 * @projectName leetcode_study
 * @description:
 * ����һ�����������ҳ�����С��ȡ�
 *
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
 *
 * ˵����Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,9,20,null,null,15,7]
 * �����2
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
