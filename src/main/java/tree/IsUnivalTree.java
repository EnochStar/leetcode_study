package tree;

/**
 * @author FL8000
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        int temp = root.val;
        return isUnivalTree(root.left,temp) && isUnivalTree(root.right,temp);
    }
    public boolean isUnivalTree(TreeNode root,int temp){
        return root == null || root.val == temp && isUnivalTree(root.left,temp) && isUnivalTree(root.right,temp);
    }
}
