package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: LetterCasePermutation
 * @projectName leetcode_study
 * @description: 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路:将字母大小写转化 可以 异或32 或者异或‘ ’(空格的ascii值为32) 数组c转String 可以 new String(c)
 * 注意回溯的时机。
 * @date 2020/12/99:31
 */
public class LetterCasePermutation {
    List<String> list = new ArrayList();
    public List<String> letterCasePermutation(String S) {
        char[] c = S.toCharArray();
        backtrack(S,c,0);
        return list;
    }
    void backtrack(String s, char[] c, int index) {
        if(s.length() == index) {
            list.add(new String(c));
            return;
        }
        backtrack(s,c,index + 1);
        if(Character.isLetter(c[index])) {
            c[index] ^= ' ';
            backtrack(s,c,index + 1);
        }
    }
}
