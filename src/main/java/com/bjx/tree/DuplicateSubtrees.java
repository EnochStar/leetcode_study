package com.bjx.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author FL8000
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 */
public class DuplicateSubtrees {
    List<TreeNode> list = new ArrayList();
    HashMap<String,Integer> map = new HashMap();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }
    public String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + ',' + right + "," + root.val;
        int flag = map.getOrDefault(subTree, 0);
        if(flag == 1){
            list.add(root);
        }
        map.put(subTree,flag + 1);
        return subTree;
    }
}
