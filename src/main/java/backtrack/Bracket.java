package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * ���š����һ���㷨����ӡn�����ŵ����кϷ��ģ����磬����һһ��Ӧ����ϡ�
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ���磬����n = 3�����ɽ��Ϊ��
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bracket-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Bracket {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return res;
    }
    void backtrack(int left, int right, StringBuilder sb){
        if(left > right) {
            return;
        }
        if(left < 0|| right < 0) {
            return;
        }
        if(left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append("(");
        backtrack(left - 1, right, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        backtrack(left, right - 1, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
