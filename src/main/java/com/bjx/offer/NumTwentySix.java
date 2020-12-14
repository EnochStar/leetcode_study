package com.bjx.offer;

/**
 * @author FL8000
 * ��Ŀ�������������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)
 *
 * B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��
 *
 * ---------------------------------------------------------
 *
 * ����������˼·���ҵ�B�ĸ��ڵ���A�е�λ�ã�û�оͷ���false���о����α����ڵ�λ�ü���ֵ����A��Ҳ�п����ж����B�ĸ��ڵ�ֵ��ͬ�Ľڵ㣩
 *
 * 1���Բ�α����ҵ��ڵ㣬Ȼ��ݹ��ж�
 *
 * 2���������Ľ��˼·���ݹ����A�ڵ㣬ͬʱ�ݹ��ж��Ƿ�Ϊ����
 */
public class NumTwentySix {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //����1
    // public boolean isSubStructure(com.zx.TreeNode A, com.zx.TreeNode B) {
    //     if(A == null || B == null)
    //         return false;
    //     // �ҵ���B�ĸ��ڵ�����A��λ�ã��ݹ�
    //     Queue<com.zx.TreeNode> queue = new LinkedList<com.zx.TreeNode>();
    //     queue.add(A);
    //     boolean flag=false;
    //     while(!queue.isEmpty()){
    //         int count = queue.size();
    //         while(count > 0){
    //             com.zx.TreeNode node = queue.poll();
    //             //���� �ж��Ƿ�Ϊ����
    //             if(node.val == B.val){
    //                 flag = isSonTree(node, B);
    //             }
    //             if(flag){
    //                 return true;
    //             }
    //             if(node.left != null)
    //                 queue.add(node.left);
    //             if(node.right != null)
    //                 queue.add(node.right);
    //             count--;
    //         }
    //     }
    //     return flag;
    // }

    //����2
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        return isSonTree(A,B)||isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }

    public boolean isSonTree(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        return A.val == B.val && isSonTree(A.left, B.left) && isSonTree(A.right, B.right);
    }
}
