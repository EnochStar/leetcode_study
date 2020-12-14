package com.bjx.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FL8000
 * 题目分析：给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * ------------------------------------------------------------------------------------------
 * 分析：
 * 思路一：用HashMap存储映射，但需要注意映射是双向的，而非单向的，如ab -> aa .只判断 ab到aa是成功的，但反过来就不对了
 * 思路二：不用HashMap而采用第三方的方式。
 */
public class IsomorphicString {

    // 思路一

    public boolean isIsomorphicWayOne(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        return Isomorphic(s,t)&&Isomorphic(t,s);
    }
    public boolean Isomorphic(String s,String t) {
        Map<Character,Character> map = new HashMap();
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    // 思路二

    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for(int i = 0;i < s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(mapS[c1] != mapT[c2]){
                return false;
            }else{
                mapS[c1] = i + 1;
                mapT[c2] = i + 1;
            }
        }
        return true;
    }
}
