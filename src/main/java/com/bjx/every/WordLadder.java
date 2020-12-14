package com.bjx.every;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FL8000
 * ��Ŀ�����������������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 * ���������������ת�����У����� 0��
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 *
 * ���ӣ�https://leetcode-cn.com/problems/word-ladder
 * ������
 * ��ȱ�����������ʼ�ַ���ÿһ�����ʽ��дӡ�a��-��z���ı仯������ֵ��а��������γ��µĿ�ʼ���С�
 * ���ֵ��в������Կ�ʼ�ַ���������һ���ַ��ı�ʱ��˵���޷�����endword��
 * Ϊ�����Ч�ʿ��Բ���˫�˹�ȱ�����ѡ��ͷ-��β ��β-��ͷ���γɽ϶̵��ַ������б�����
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> beginSet = new HashSet();
        HashSet<String> endSet = new HashSet();
        HashSet<String> all = new HashSet(wordList);
        if (!all.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        return bfs(beginSet, endSet, all, 2);
    }

    public int bfs(Set<String> bs, Set<String> es, Set<String> as, int num) {
        if (bs.size() == 0) {
            return 0;
        }
        if (bs.size() > es.size()) {
            return bfs(es, bs, as, num);
        }
        as.removeAll(bs);
        HashSet<String> next = new HashSet<>();
        // ������ʼ�ֶε�ÿһ��ֵ����ȡ�޸�һ�����ʵ�����
        for (String s : bs) {
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char temp = cs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if(temp == c){
                        continue;
                    }
                    cs[i] = c;
                    String temps = new String(cs);
                    if (as.contains(temps)) {
                        if (es.contains(temps)) {
                            return num;
                        } else {
                            next.add(temps);
                        }
                    }
                }
                cs[i] = temp;
            }
        }
        return bfs(next, es, as, num + 1);
    }
}
