package com.bjx.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FL8000
 * ��Ŀ���������������ַ��� s �� t���ж������Ƿ���ͬ���ġ�
 *
 * ��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�
 *
 * ���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
 *
 * ���ӣ�https://leetcode-cn.com/problems/isomorphic-strings
 * ------------------------------------------------------------------------------------------
 * ������
 * ˼·һ����HashMap�洢ӳ�䣬����Ҫע��ӳ����˫��ģ����ǵ���ģ���ab -> aa .ֻ�ж� ab��aa�ǳɹ��ģ����������Ͳ�����
 * ˼·��������HashMap�����õ������ķ�ʽ��
 */
public class IsomorphicString {

    // ˼·һ

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

    // ˼·��

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
