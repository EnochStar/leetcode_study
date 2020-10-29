package every;

/**
 * @author FL8000
 * ��Ŀ����������һ��������������ÿ����㶼���һ�� 0-9 �����֣�ÿ���Ӹ���Ҷ�ӽڵ��·��������һ�����֡�
 *
 * ���磬�Ӹ���Ҷ�ӽڵ�·�� 1->2->3 �������� 123��
 *
 * ����Ӹ���Ҷ�ӽڵ����ɵ���������֮�͡�
 *
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ���ӣ�https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 *
 * ������
 * �򵥵ݹ飬�����ҽڵ㶼Ϊ����Ϊ��ֹ����������ȫ�ֱ�����¼���
 */
public class SumOfTree {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return sum;
        }
        sumAdd(root, root.val);
        return sum;
    }
    public void sumAdd(TreeNode root, int num){
        if(root.left == null && root.right == null){
            sum += num;
        }
        if(root.left != null){
            sumAdd(root.left, num * 10 + root.left.val);
        }
        if(root.right != null){
            sumAdd(root.right, num * 10 + root.right.val);
        }
    }
}
