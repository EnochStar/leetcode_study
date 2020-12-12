package backtrack;

import java.util.*;

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
        boolean[] flag = new boolean[c.length];
        Arrays.sort(c);
        backtrack(c,new StringBuilder(),flag);
        return set.toArray(new String[set.size()]);
    }
    void backtrack(char[] c,StringBuilder sb,boolean[] flag){
        if (sb.length() == c.length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < c.length;i++) {
            if(flag[i]){
                continue;
            }
            if(i > 0 && c[i] == c[i-1] && !flag[i-1]) continue;
            sb.append(c[i]);
            flag[i] = true;
            backtrack(c,sb,flag);
            flag[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
