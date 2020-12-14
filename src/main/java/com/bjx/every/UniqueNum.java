package com.bjx.every;

import java.util.*;

/**
 * @author FL8000
 * ��Ŀ����������һ���������� arr�������æͳ��������ÿ�����ĳ��ִ�����
 *
 * ���ÿ�����ĳ��ִ������Ƕ�һ�޶��ģ��ͷ��� true�����򷵻� false��
 *
 * -------------------------------------------------------------
 *
 * ��������map�洢ÿ��������Ӧ���ִ���
 * ��set�����Ƿ�����ظ��Ĵ���
 */
public class UniqueNum {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : arr){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }
        return map.size() == new HashSet<Integer>(map.values()).size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        boolean flag = uniqueOccurrences(arr);
        System.out.println(flag);
    }
}
