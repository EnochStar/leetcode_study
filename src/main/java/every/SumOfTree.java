package every;

/**
 * @author FL8000
 * 题目分析：给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 *
 * 分析：
 * 简单递归，以左右节点都为空作为终止条件，设置全局变量记录结果
 */
public class SumOfTree {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return sum;
        }
        sumAdd(root, root.val);
        return sum;
    }
    public void sumAdd(TreeNode root, int num){
        if(root.left == null && root.right == null){
            sum += num;
        }
        if(root.left != null){
            sumAdd(root.left, num * 10 + root.left.val);
        }
        if(root.right != null){
            sumAdd(root.right, num * 10 + root.right.val);
        }
    }
}
