package com.bjx.offer;

/**
 * @author FL8000
 * ��Ŀ������
 * ��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
 * -----------------------------------------------------------------------------
 */
public class NumTwentyEight {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left == null || right == null) || left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
