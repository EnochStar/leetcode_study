package com.bjx.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EnochStar
 * @title: IsAnagram
 * @projectName leetcode_study
 * @description: 
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 *
 * ʾ��1:
 *
 * ����: s = "anagram", t = "nagaram"
 * ���: true
 * ʾ�� 2:
 *
 * ����: s = "rat", t = "car"
 * ���: false
 * ˵��:
 * ����Լ����ַ���ֻ����Сд��ĸ��
 *
 * ����:
 * ��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-anagram
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/1 10:04
 */
public class IsAnagram {
    // ����һ������sort���ж�
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }

    // ����������HashMap
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

    // ��������������
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
