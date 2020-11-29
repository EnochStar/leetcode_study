package tree;

/**
 * @author FL8000
 * �ڶ������У����ڵ�λ����� 0 ����ÿ�����Ϊ k �Ľڵ���ӽڵ�λ����� k+1 ����
 *
 * ����������������ڵ������ͬ�������ڵ㲻ͬ����������һ�����ֵܽڵ㡣
 *
 * ���Ǹ����˾���Ψһֵ�Ķ������ĸ��ڵ� root���Լ�����������ͬ�ڵ��ֵ x �� y��
 *
 * ֻ����ֵ x �� y ��Ӧ�Ľڵ������ֵܽڵ�ʱ���ŷ��� true�����򣬷��� false��
 *
 *            1
 *       2         3
 *   4
 * ���룺root = [1,2,3,4], x = 4, y = 3
 * �����false
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/cousins-in-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsCousins {
    int xpar,ypar,xhigh,yhigh;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        dfs(root.left, x, y, root.val, 1);
        dfs(root.right, x, y, root.val, 1);
        return (xpar != ypar) && (xhigh == yhigh);
    }
    public void dfs(TreeNode node, int x, int y, int par, int dep) {
        if(node == null) {
            return;
        }
        if(node.val == x) {
            xpar = par;
            xhigh = dep;
        }
        if(node.val == y) {
            ypar = par;
            yhigh = dep;
        }
        dfs(node.left, x, y, node.val, dep + 1);
        dfs(node.right, x, y, node.val, dep + 1);
    }
}
