package every;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author FL8000
 * 题目描述：给定一个二叉树，返回它的前序遍历。
 * ---------------------------------------------------------
 * 分析
 * 递归：读root，递归left，递归right
 * 迭代：栈
 * 同时有中序和后序遍历模板
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }
};

public class PreTree {
    List<Integer> arr = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        preorder(root);
        return arr;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // 迭代方式
    public List<Integer> preorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return list;
    }

    // 中序模板 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        inorder(root);
        return arr;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    // 中序模板 迭代
    public List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            arr.add(cur.val);
            root = cur.right;
        }
        return arr;
    }

    // 后序遍历 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return arr;
        }
        postorder(root);
        return arr;
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        arr.add(root.val);
    }

    //后序遍历 迭代
    public List<Integer> postorderTraversalStack(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            res.addFirst(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return res;
    }
}
