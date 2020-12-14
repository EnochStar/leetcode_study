package com.bjx.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * �����������ĸ��ڵ� root������ÿ���ڵ㶼��һ����ͬ��ֵ��
 *
 * ����ڵ�ֵ�� to_delete �г��֣����ǾͰѸýڵ������ɾȥ�����õ�һ��ɭ�֣�һЩ���ཻ�������ɵļ��ϣ���
 *
 * ����ɭ���е�ÿ����������԰�����˳����֯�𰸡�
 *
 *  
 *
 * ʾ����
 *          1
 *     2         3
 * 4      5    6    7
 * ���룺root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * �����[[1,2,null,4],[6],[7]]
 *  
 *
 * ��ʾ��
 *
 * ���еĽڵ������Ϊ 1000��
 * ÿ���ڵ㶼��һ������ 1 �� 1000 ֮���ֵ���Ҹ�����ͬ��
 * to_delete.length <= 1000
 * to_delete ����һЩ�� 1 �� 1000��������ͬ��ֵ��
 *
 * ���ӣ�https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> list = new ArrayList();
    Set<Integer> set;
    // ����set
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return list;
        }
        set = new HashSet();
        for(int i : to_delete) {
            set.add(i);
        }
        if(!set.contains(root.val)){
            list.add(root);
        }
        preOrder(root);
        return list;
    }
    public TreeNode preOrder(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = preOrder(root.left);
        root.right = preOrder(root.right);
        if(set.contains(root.val)) {
            if(root.left != null) {
                list.add(root.left);
            }
            if(root.right != null) {
                list.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
