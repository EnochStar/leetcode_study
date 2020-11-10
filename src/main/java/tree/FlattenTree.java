package tree;

/**
 * @author FL8000
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class FlattenTree {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
