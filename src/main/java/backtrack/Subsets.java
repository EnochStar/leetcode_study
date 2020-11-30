package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ʾ��:
 *
 * ����: nums = [1,2,3]
 * ���:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/subsets
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList());
        return res;
    }
    void backtrack(int[] nums, int index,LinkedList<Integer> list) {
        res.add(new LinkedList(list));
        for(int i = index; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.removeLast();
        }
    }
}
