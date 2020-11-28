package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * ����һ�ö�������ÿ���ڵ��ֵΪ 1 �� 9 �����ǳƶ������е�һ��·���� ��α���ġ��ģ��������㣺·�����������нڵ�ֵ�������У�����һ���������С�
 *
 * ���㷵�شӸ���Ҷ�ӽڵ������·���� α���� ·������Ŀ��
 *
 * ���ӣ�https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 */
public class PseudoPalindromicPaths {
    int sum = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) {
            return sum;
        }
        count(root,new HashSet());
        return sum;
    }
    public void count(TreeNode root, Set<Integer> set) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null){
            if(set.size() == 0 || set.size() <= 2 && set.contains(root.val)) sum++;
            return;
        }
        if(set.contains(root.val)) set.remove(root.val);
        else set.add(root.val);
        count(root.left,set);
        count(root.right,set);
        if(set.contains(root.val)) set.remove(root.val);
        else set.add(root.val);
    }
}
