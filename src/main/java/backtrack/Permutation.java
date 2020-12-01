package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * ���ظ��ַ�����������ϡ���дһ�ַ���������ĳ�ַ���������������ϡ�
 *
 * ʾ��1:
 *
 *  ���룺S = "qqe"
 *  �����["eqq","qeq","qqe"]
 *
 * ʾ��2:
 *
 *  ���룺S = "ab"
 *  �����["ab", "ba"]
 *
 * ��ʾ:
 *
 * �ַ�����Ӣ����ĸ��
 * �ַ���������[1, 9]֮�䡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutation-ii-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Permutation {
    Set<String> set = new HashSet<>();
    public String[] permutation(String S) {
        char[] c = S.toCharArray();
        backtrack(c,new StringBuilder(),0);
        return set.toArray(new String[set.size()]);
    }
    void backtrack(char[] c,StringBuilder sb,int index){
        if (sb.length() == c.length) {
            set.add(sb.toString());
        }
        for (int i = 0;i < c.length;i++) {
            sb.append(c[i]);
            backtrack(c,sb,index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
