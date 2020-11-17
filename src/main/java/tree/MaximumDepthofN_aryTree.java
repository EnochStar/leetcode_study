package tree;

/**
 * @author FL8000
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个  3叉树  :
 *
 *          1
 *    3     2      4
 * 5    6
 *
 *   
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过  1000。
 * 树的节点总不会超过  5000。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 */
public class MaximumDepthofN_aryTree {
    public int maxDepth(nNode root) {
        if(root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 1;
        for(nNode node : root.children) {
            max = Math.max(max,maxDepth(node)+1);
        }
        return max;
    }
}
