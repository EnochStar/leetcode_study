package tree;

import java.util.LinkedList;

/**
 * @author FL8000
 * ���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
 *
 * �����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
 *
 * ʾ��:
 *
 * ����Խ����¶�������
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * ���л�Ϊ "[1,2,3,null,null,4,5]"
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Codec {
    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    public void serialize(TreeNode root,StringBuilder sb) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList();
        for(String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        TreeNode root = deserialize(nodes);
        return root;
    }
    public TreeNode deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String fis = list.removeFirst();
        if(fis.equals(NULL)) return null;
        TreeNode temp = new TreeNode(Integer.parseInt(fis));
        temp.left = deserialize(list);
        temp.right = deserialize(list);
        return temp;
    }
}
