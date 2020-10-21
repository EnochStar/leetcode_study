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
 * 题目描述：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * -------------------------------------------------------------
 * 分析：1、递归遍历左右子树，分别以该子树为根进行左右子树的交换
 *      2、辅助栈
 */
public class NumTwentySeven {
    // 方法1
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
    //方法2
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
