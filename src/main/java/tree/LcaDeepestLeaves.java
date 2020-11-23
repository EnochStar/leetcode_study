package tree;

/**
 * @author FL8000
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的  深度  为  0，如果某一节点的深度为  d，那它的子节点的深度就是  d+1
 * 如果我们假定 A 是一组节点  S  的 最近公共祖先，S  中的每个节点都在以 A 为根节点的子树中，且 A  的深度达到此条件下可能的最大值。
 *   
 *
 * 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 *   
 *
 * 示例 1：
 *         3
 *     5        1
 *  6    2    0   8
 *      7 4
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves
 */
public class LcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == right) {
            return root;
        }
        if(left > right) {
            return lcaDeepestLeaves(root.left);
        }else {
            return lcaDeepestLeaves(root.right);
        }
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left,right) + 1;
    }
}
