package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * �ҳ��������֮��Ϊ   n ��   k   ��������ϡ������ֻ������ 1 -   9 ��������������ÿ������в������ظ������֡�
 *
 * ˵����
 *
 * �������ֶ�����������
 * �⼯���ܰ����ظ�����ϡ�   
 * ʾ�� 1:
 *
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ʾ�� 2:
 *
 * ����: k = 3, n = 9
 * ���: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, 1, new LinkedList());
        return res;
    }
    void backtrack(int n, int k, int start, LinkedList list) {
        if(list.size() >= k) {
            if(sum(list) == n)res.add(new LinkedList(list));
            return;
        }
        for(int i = start; i < 10; i++) {
            list.add(i);
            backtrack(n,k,i + 1,list);
            // if(sum(list) > n) {
            //     list.removeLast();
            //     break;
            // }
            list.removeLast();
        }
    }
    int sum(LinkedList<Integer> list) {
        int sum = 0;
        for(int i = 0;i < list.size();i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
