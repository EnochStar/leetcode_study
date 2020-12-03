package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
