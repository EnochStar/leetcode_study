package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 *
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
