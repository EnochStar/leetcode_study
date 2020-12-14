package com.bjx.tree;

/**
 * @author FL8000
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 */
public class Tree2str {
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if(t.left == null && t.right == null) {
            return sb.toString();
        }
        tree2str(t.left,sb);
        if(t.right != null) {
            tree2str(t.right,sb);
        }
        return sb.toString();
    }
    public void tree2str(TreeNode t,StringBuilder sb) {
        sb.append("(");
        if(t == null) {
            sb.append(")");
            return;
        }
        sb.append(t.val);
        if(t.left != null && t.right == null){
            tree2str(t.left,sb);
            sb.append(")");
            return;
        }
        if(t.left == null && t.right == null) {
            sb.append(")");
            return;
        }
        tree2str(t.left,sb);
        tree2str(t.right,sb);
        sb.append(")");
    }
}
