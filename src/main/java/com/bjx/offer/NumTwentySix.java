package com.bjx.offer;

/**
 * @author FL8000
 * 题目描述：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * ---------------------------------------------------------
 *
 * 分析：基本思路，找到B的根节点在A中的位置，没有就返回false，有就依次遍历节点位置即其值（在A中也有可能有多个与B的根节点值相同的节点）
 *
 * 1、以层次遍历找到节点，然后递归判断
 *
 * 2、很优美的解决思路，递归遍历A节点，同时递归判断是否为子树
 */
public class NumTwentySix {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //方法1
    // public boolean isSubStructure(com.zx.TreeNode A, com.zx.TreeNode B) {
    //     if(A == null || B == null)
    //         return false;
    //     // 找到树B的根节点在树A的位置，递归
    //     Queue<com.zx.TreeNode> queue = new LinkedList<com.zx.TreeNode>();
    //     queue.add(A);
    //     boolean flag=false;
    //     while(!queue.isEmpty()){
    //         int count = queue.size();
    //         while(count > 0){
    //             com.zx.TreeNode node = queue.poll();
    //             //遍历 判断是否为子树
    //             if(node.val == B.val){
    //                 flag = isSonTree(node, B);
    //             }
    //             if(flag){
    //                 return true;
    //             }
    //             if(node.left != null)
    //                 queue.add(node.left);
    //             if(node.right != null)
    //                 queue.add(node.right);
    //             count--;
    //         }
    //     }
    //     return flag;
    // }

    //方法2
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        return isSonTree(A,B)||isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }

    public boolean isSonTree(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        return A.val == B.val && isSonTree(A.left, B.left) && isSonTree(A.right, B.right);
    }
}
