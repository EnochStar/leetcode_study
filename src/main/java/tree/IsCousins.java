package tree;

/**
 * @author FL8000
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *            1
 *       2         3
 *   4
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCousins {
    int xpar,ypar,xhigh,yhigh;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        dfs(root.left, x, y, root.val, 1);
        dfs(root.right, x, y, root.val, 1);
        return (xpar != ypar) && (xhigh == yhigh);
    }
    public void dfs(TreeNode node, int x, int y, int par, int dep) {
        if(node == null) {
            return;
        }
        if(node.val == x) {
            xpar = par;
            xhigh = dep;
        }
        if(node.val == y) {
            ypar = par;
            yhigh = dep;
        }
        dfs(node.left, x, y, node.val, dep + 1);
        dfs(node.right, x, y, node.val, dep + 1);
    }
}
