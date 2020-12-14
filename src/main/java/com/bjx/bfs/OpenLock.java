package com.bjx.bfs;

import java.util.*;

/**
 * @author EnochStar
 * @title: OpenLock
 * @projectName leetcode_study
 * @description: 
 * ����һ�������ĸ�Բ�β��ֵ�ת������ÿ�����ֶ���10�����֣� '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ��ÿ�����ֿ���������ת������� '9' ��Ϊ  '0'��'0' ��Ϊ '9' ��ÿ����ת��ֻ����תһ�����ֵ�һλ���֡�
 *
 * ���ĳ�ʼ����Ϊ '0000' ��һ�������ĸ����ֵ����ֵ��ַ�����
 *
 * �б� deadends ������һ���������֣�һ�����ֵ����ֺ��б�����κ�һ��Ԫ����ͬ����������ᱻ�����������޷��ٱ���ת��
 *
 * �ַ��� target ������Խ��������֣�����Ҫ������С����ת���������������β��ܽ��������� -1��
 *
 *  
 *
 * ʾ�� 1:
 *
 * ���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * �����6
 * ���ͣ�
 * ���ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
 * ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
 * ��Ϊ�������� "0102" ʱ������ͻᱻ������
 * ʾ�� 2:
 *
 * ����: deadends = ["8888"], target = "0009"
 * �����1
 * ���ͣ�
 * �����һλ������תһ�μ��� "0000" -> "0009"��
 * ʾ�� 3:
 *
 * ����: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * �����-1
 * ���ͣ�
 * �޷���ת��Ŀ�������Ҳ���������
 * ʾ�� 4:
 *
 * ����: deadends = ["0000"], target = "8888"
 * �����-1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/open-the-lock
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/14 9:21
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String start = "0000";
        int depth = 0;
        if (set.contains(start)) return 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0;i < sz; i++) {
                String cur = queue.poll();
                // ������deadendsʱ ���޷�������
                if (set.contains(cur)) continue;
                if (cur.equals(target)) return depth;
                for (int j = 0;j < 4;j++) {
                    String fis = plusOne(cur,j);
                    if (!visited.contains(fis)) {
                        queue.add(fis);
                        visited.add(fis);
                    }
                    String sec = minusOne(cur,j);
                    if (!visited.contains(sec)) {
                        queue.add(sec);
                        visited.add(sec);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
    public String plusOne(String s,int index) {
        char[] c = s.toCharArray();
        if (c[index] == '9') c[index] = '0';
        else c[index]++;
        return new String(c);
    }
    public String minusOne(String s,int index) {
        char[] c = s.toCharArray();
        if (c[index] == '0') c[index] = '9';
        else c[index]--;
        return new String(c);
    }
}
