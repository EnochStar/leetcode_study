package tree;

/**
 * @author FL8000
 * ��������������ĸ��ڵ� root ��ͬʱ������С�߽�low �����߽� high��ͨ���޼�������������ʹ�����нڵ��ֵ��[low, high]�С��޼�����Ӧ�øı䱣�������е�Ԫ�ص���Խṹ���������û�б��Ƴ���ԭ�еĸ����Ӵ���ϵ��Ӧ���������� ����֤��������Ψһ�Ĵ𰸡�
 *
 * ���Խ��Ӧ�������޼��õĶ������������µĸ��ڵ㡣ע�⣬���ڵ���ܻ���ݸ����ı߽緢���ı䡣
 *
 *     1
 *  0     2
 * ���룺root = [1,0,2], low = 1, high = 2
 * �����[1,null,2]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low)
            return trimBST(root.right, low, high);
        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
