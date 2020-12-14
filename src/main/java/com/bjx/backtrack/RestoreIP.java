package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author EnochStar
 * @title: RestoreIP
 * @projectName leetcode_study
 * @description: ����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ��
 *
 * ��Ч�� IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 *
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч�� IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч�� IP ��ַ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "25525511135"
 * �����["255.255.11.135","255.255.111.35"]
 * ʾ�� 2��
 *
 * ���룺s = "0000"
 * �����["0.0.0.0"]
 * ʾ�� 3��
 *
 * ���룺s = "1111"
 * �����["1.1.1.1"]
 * ʾ�� 4��
 *
 * ���룺s = "010010"
 * �����["0.10.0.10","0.100.1.0"]
 * ʾ�� 5��
 *
 * ���룺s = "101023"
 * �����["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * ��ʾ��
 *
 * 0 <= s.length <= 3000
 * s �����������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/restore-ip-addresses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/620:54
 */
public class RestoreIP {
    List<String> res = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if(len < 4 || len > 12) {
            return res;
        }
        backtrack(s, len, 0, 4, new LinkedList());
        return res;
    }
    void backtrack(String s, int len, int begin, int residue, LinkedList<String> list) {
        if(begin == len) {
            if(residue == 0) {
                res.add(String.join(".",list));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) break;
            if (residue * 3 < len - i) break;
            if (judgeIPSegment(s,begin,i)) {
                String temp = s.substring(begin,i + 1);
                list.addLast(temp);
                backtrack(s,len,i + 1, residue - 1, list);
                list.removeLast();
            }
        }
    }
    boolean judgeIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        int num = 0;
        if (len > 1 && s.charAt(left) == '0') return false;
        while (left <= right) {
            num = num * 10 + s.charAt(left) - '0';
            left++;
        }
        return num >= 0 && num <= 255;
    }
    //������еı�����ѧ
    public List<String> restoreIpAddresses_zero(String s) {
        List<String> ret = new ArrayList<>();

        StringBuilder ip = new StringBuilder();

        for(int a = 1 ; a < 4 ; ++ a)
            for(int b = 1 ; b < 4 ; ++ b)
                for(int c = 1 ; c < 4 ; ++ c)
                    for(int d = 1 ; d < 4 ; ++ d)
                    {
                        if(a + b + c + d == s.length() )
                        {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a+b));
                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                            {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                //010 parseInt 10 ���ж�
                                if(ip.length() == s.length() + 3) ret.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
        return ret;
    }
}
