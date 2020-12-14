package com.bjx.offer;

/**
 * @author FL8000
 * 题目分析：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * --------------------------------------------------------------------------
 *
 * 分析：后序遍历形成数组，最后一个一定是根节点，从前往后找到第一个大于根节点的值作为边界，划分左右子树
 */
public class NumThirtyThree {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    public boolean recur(int[] postorder, int start, int end){
        if (start >= end){
            return true;
        }
        int p = start;
        while(postorder[p] < postorder[end]){
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[end]){
            p++;
        }
        return p == end && recur(postorder, start, m-1) && recur(postorder, m, end-1);
    }
}
