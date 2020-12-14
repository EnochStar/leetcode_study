package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: PermutationSimple
 * @projectName leetcode_study
 * @description:
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/12 21:58
 */
public class PermutationSimple {
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] c = S.toCharArray();
        boolean[] flag = new boolean[c.length];
        backtrack(new StringBuilder(),c,flag);
        return list.toArray(new String[0]);
    }
    void backtrack(StringBuilder sb,char[] c,boolean[] flag) {
        if (sb.length() == c.length) {
            list.add(sb.toString());
        }
        for (int i = 0; i < c.length;i++) {
            if (flag[i])
                continue;
            sb.append(c[i]);
            flag[i] = true;
            backtrack(sb,c,flag);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}
