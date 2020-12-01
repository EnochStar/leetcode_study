package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 *
 * candidates �е����ֿ����������ظ���ѡȡ��
 *
 * ˵����
 *
 * �������֣����� target��������������
 * �⼯���ܰ����ظ�����ϡ� 
 * ʾ�� 1��
 *
 * ���룺candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ��
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * ʾ�� 2��
 *
 * ���룺candidates = [2,3,5], target = 8,
 * ����⼯Ϊ��
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target,new LinkedList());
        return res;
    }
    public void backtrack(int[] candidates, int idx, int target, LinkedList<Integer> arr) {
        if(sum(arr) > target || (idx == target && sum(arr) != target)) {
            return;
        }
        if(sum(arr) == target) {
            res.add(new LinkedList(arr));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            arr.add(candidates[i]);
            backtrack(candidates, i, target, arr);
            arr.removeLast();
        }
    }
    int sum(LinkedList<Integer> arr) {
        int sum = 0;
        for(int i = 0;i < arr.size();i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
