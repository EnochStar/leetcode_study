package tree;

/**
 * @author FL8000
 * ���������ÿ���ڵ㶼������ͬ��ֵ����ô�ö��������ǵ�ֵ��������
 *
 * ֻ�и��������ǵ�ֵ������ʱ���ŷ��� true�����򷵻� false��
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        int temp = root.val;
        return isUnivalTree(root.left,temp) && isUnivalTree(root.right,temp);
    }
    public boolean isUnivalTree(TreeNode root,int temp){
        return root == null || root.val == temp && isUnivalTree(root.left,temp) && isUnivalTree(root.right,temp);
    }
}
