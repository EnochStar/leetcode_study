package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author FL8000
 * ����һ��������������Ķ�������
 *
 * root.val == 0
 * ��� treeNode.val == x ��  treeNode.left != null����ô  treeNode.left.val == 2 * x + 1
 * ��� treeNode.val == x �� treeNode.right != null����ô  treeNode.right.val == 2 * x + 2
 * ��������������ܵ�����Ⱦ�������е�  treeNode.val  �������  -1��
 *
 * �����Ȼ�ԭ��������Ȼ��ʵ��  FindElements  �ࣺ
 *
 * FindElements(TreeNode* root)  ������Ⱦ�Ķ�������ʼ����������Ҫ�Ȱ�����ԭ��
 * bool find(int target)  �ж�Ŀ��ֵ  target  �Ƿ�����ڻ�ԭ��Ķ������в����ؽ����
 *   
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        if (root == null){
            return;
        }
        root.val = 0;
        if (root.left != null) {
            root.left = dfs(root);
        }
        if (root.right != null) {
            root.right = dfs(root);
        }
    }
    public TreeNode dfs(TreeNode node) {
        TreeNode temp = new TreeNode(2 * node.val + 1);
        if (node.left != null){
            temp.left = dfs(temp);
        }
        if (node.right != null) {
            temp.right = dfs(temp);
        }
        return temp;
    }

    public boolean find(int target) {
        return find(root,target);
    }
    public boolean find(TreeNode root, int target) {
        if (root == null){
            return false;
        }
        return root.val == target || find(root.left,target) || find(root.right,target);
    }
}
