package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 */
public class PseudoPalindromicPaths {
    int sum = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) {
            return sum;
        }
        count(root,new HashSet());
        return sum;
    }
    public void count(TreeNode root, Set<Integer> set) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null){
            if(set.size() == 0 || set.size() <= 2 && set.contains(root.val)) sum++;
            return;
        }
        if(set.contains(root.val)) set.remove(root.val);
        else set.add(root.val);
        count(root.left,set);
        count(root.right,set);
        if(set.contains(root.val)) set.remove(root.val);
        else set.add(root.val);
    }
}
