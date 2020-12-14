package com.bjx.tree;

/**
 * 给你一棵二叉树，它的根为root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 *         1
 *     2        3
 *  4    5    6
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    private int sum=0;
    private long max=0;
    public int maxProduct(TreeNode root) {
        this.sum=getSum(root);
        SeqTraversal(root);
        return (int) (max%1000000007);
    }
    // 最大值即判断 max = Math.max(temp * （sum - temp）,max)
    private void SeqTraversal(TreeNode root){
        if(root==null){
            return;
        }
        long a=root.val,b=sum-root.val;
        max=Math.max(max,a*b);
        SeqTraversal(root.left);
        SeqTraversal(root.right);
    }
    // 记录每个节点下包括其左右节点相加的值
    private int getSum(TreeNode root){
        if(root==null) return 0;
        root.val=getSum(root.left)+getSum(root.right)+root.val;
        return root.val;
    }
}
