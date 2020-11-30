package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author FL8000
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且  treeNode.left != null，那么  treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么  treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的  treeNode.val  都变成了  -1。
 *
 * 请你先还原二叉树，然后实现  FindElements  类：
 *
 * FindElements(TreeNode* root)  用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target)  判断目标值  target  是否存在于还原后的二叉树中并返回结果。
 *   
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
}
