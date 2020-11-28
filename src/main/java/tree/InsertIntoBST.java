package tree;

/**
 * @author FL8000
 * ����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� ���ز��������������ĸ��ڵ㡣 �������� ��֤ ����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
 *
 * ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ� ����Է��� ������Ч�Ľ�� ��
 *
 * ���ӣ�https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
