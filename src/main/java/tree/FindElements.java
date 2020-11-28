package tree;

import sun.reflect.generics.tree.Tree;

public class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        if (root == null){
            return;
        }
        root.val = 0;
        if (root.left != null) {
            root.left = dfs(root);
        }
        if (root.right != null) {
            root.right = dfs(root);
        }
    }
    public TreeNode dfs(TreeNode node) {
        TreeNode temp = new TreeNode(2 * node.val + 1);
        if (node.left != null){
            temp.left = dfs(temp);
        }
        if (node.right != null) {
            temp.right = dfs(temp);
        }
        return temp;
    }

    public boolean find(int target) {
        return find(root,target);
    }
    public boolean find(TreeNode root, int target) {
        if (root == null){
            return false;
        }
        return root.val == target || find(root.left,target) || find(root.right,target);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(-1);
        treeNode.right = new TreeNode(-1);
        treeNode.left.left = new TreeNode(-1);
        treeNode.left.right = new TreeNode(-1);
        FindElements findElements = new FindElements(treeNode);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));
    }
}
