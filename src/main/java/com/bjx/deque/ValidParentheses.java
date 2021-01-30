package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: ValidParentheses
 * @projectName leetcode_study
 * @description:
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'���ַ��� s ���ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * 
 *
 * ʾ�� 1��
 *
 * ���룺s = "()"
 * �����true
 * ʾ��2��
 *
 * ���룺s = "()[]{}"
 * �����true
 * ʾ��3��
 *
 * ���룺s = "(]"
 * �����false
 * ʾ��4��
 *
 * ���룺s = "([)]"
 * �����false
 * ʾ��5��
 *
 * ���룺s = "{[]}"
 * �����true
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-parentheses
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/30 11:04
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.offerFirst(')');
            }else if (c == '[') {
                deque.offerFirst(']');
            }else if (c == '{') {
                deque.offerFirst('}');
            }else {
                if (deque.isEmpty() || c != deque.pop()) {
                     return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
