package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 */
public class AverageofLevelsinBinaryTree {
    List<Double> list = new ArrayList();
    public List<Double> averageOfLevels(TreeNode root) {
        levelOrder(root);
        return list;
    }
    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            double num = queue.size();
            double count = num;
            double sum = 0;
            while(num > 0){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                num--;
            }
            list.add(sum/count);
        }
    }
}
