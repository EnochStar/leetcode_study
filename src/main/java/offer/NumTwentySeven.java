package offer;

import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }
};
/**
 * @author FL8000
 * ��Ŀ�����������һ������������һ�����������ú���������ľ���
 * -------------------------------------------------------------
 * ������1���ݹ���������������ֱ��Ը�����Ϊ���������������Ľ���
 *      2������ջ
 */
public class NumTwentySeven {
    // ����1
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    //����2
    public TreeNode mirrorTreeByStack(TreeNode root){
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.left != null){
                stack.add(temp.left);
            }
            if (temp.right != null){
                stack.add(temp.right);
            }
            TreeNode swap = temp.right;
            temp.right = temp.left;
            temp.left = swap;
        }
        return root;
    }
}
