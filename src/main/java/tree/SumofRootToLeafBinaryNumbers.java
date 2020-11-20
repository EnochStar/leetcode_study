package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *         1
 *    0        1
 * 0     1   0     1
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 */
public class SumofRootToLeafBinaryNumbers {
    List<List<Integer>> arr;
    public int sumRootToLeaf(TreeNode root) {
        arr = new ArrayList();
        dfs(root,new ArrayList());
        int sum = 0;
        for(List<Integer> list : arr) {
            for(int i = 0;i < list.size();i++) {
                sum += list.get(i) * Math.pow(2,list.size() - i - 1);
            }
        }
        return sum;
    }
    public void dfs(TreeNode root, List<Integer> temp) {
        if(root == null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            arr.add(temp);
        }else{
            dfs(root.left,new ArrayList(temp));
            dfs(root.right,new ArrayList(temp));
        }
    }
}
