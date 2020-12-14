package com.bjx.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *  
 *
 * 示例：
 *          1
 *     2         3
 * 4      5    6    7
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *  
 *
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 *
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> list = new ArrayList();
    Set<Integer> set;
    // 生成set
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return list;
        }
        set = new HashSet();
        for(int i : to_delete) {
            set.add(i);
        }
        if(!set.contains(root.val)){
            list.add(root);
        }
        preOrder(root);
        return list;
    }
    public TreeNode preOrder(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = preOrder(root.left);
        root.right = preOrder(root.right);
        if(set.contains(root.val)) {
            if(root.left != null) {
                list.add(root.left);
            }
            if(root.right != null) {
                list.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
