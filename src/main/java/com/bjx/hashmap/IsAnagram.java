package com.bjx.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EnochStar
 * @title: IsAnagram
 * @projectName leetcode_study
 * @description: 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/1 10:04
 */
public class IsAnagram {
    // 方法一、调用sort，判断
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }

    // 方法二、用HashMap
    public boolean isAnagramTwo(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                return false;
            }else if (map.get(c) > 1) {
                map.put(c,map.get(c) - 1);
            }else{
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    // 方法三、用数组
    public boolean isAnagramThree(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for(char c : s.toCharArray()) {
            s1[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            t1[c - 'a']++;
        }
        for (int j = 0;j < 26;j++) {
            if (t1[j] != s1[j]) {
                return false;
            }
        }
        return true;
    }
}
