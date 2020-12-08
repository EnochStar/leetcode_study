package backtrack;

import java.util.LinkedList;

/**
 * @author EnochStar
 * @title: BeautifulArrangement
 * @projectName leetcode_study
 * @description: �����д� 1 �� N �� N ��������������� N �������гɹ������һ�����飬ʹ������ĵ� i λ (1 <= i <= N) �����������������е�һ�������Ǿͳ��������Ϊһ�����������С�������
 *
 * �� i λ�������ܱ� i ����
 * i �ܱ��� i λ�ϵ���������
 * ���ڸ���һ������ N�����ʿ��Թ�����ٸ����������У�
 *
 * ʾ��1:
 *
 * ����: 2
 * ���: 2
 * ����:
 *
 * �� 1 �������������� [1, 2]:
 *   �� 1 ��λ�ã�i=1���ϵ�������1��1�ܱ� i��i=1������
 *   �� 2 ��λ�ã�i=2���ϵ�������2��2�ܱ� i��i=2������
 *
 * �� 2 �������������� [2, 1]:
 *   �� 1 ��λ�ã�i=1���ϵ�������2��2�ܱ� i��i=1������
 *   �� 2 ��λ�ã�i=2���ϵ�������1��i��i=2���ܱ� 1 ����
 * ˵��:
 *
 * N ��һ�������������Ҳ��ᳬ��15��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/beautiful-arrangement
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/815:54
 */
public class BeautifulArrangement {
    int count = 0;
    boolean[] used;
    public int countArrangement(int N) {
        used = new boolean[N + 1];
        backtrack(N,1,new LinkedList());
        return count;
    }
    void backtrack(int n,int index,LinkedList<Integer> list) {
        if(index > n) {
            count++;
        }
        for(int i = 1;i <= n;i++) {
            if(used[i]) continue;
            if(i % index != 0 && index % i != 0) {
                continue;
            }
            list.add(i);
            used[i] = true;
            backtrack(n,index + 1,list);
            list.removeLast();
            used[i] = false;
        }
    }
}
