package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 *  ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
 *
 *   
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,2]
 * �����
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * ʾ�� 2��
 *
 * ���룺nums = [1,2,3]
 * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ����Ĺؼ�������μ�֦��
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        backtrack(nums, flag, new LinkedList());
        return res;
    }
    void backtrack(int[] nums, boolean[] flag, LinkedList<Integer> arr) {
        if(nums.length == arr.size()) {
            res.add(new LinkedList(arr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]){
                continue;
            }
            arr.add(nums[i]);
            flag[i] = true;
            backtrack(nums, flag, arr);
            flag[i] = false;
            arr.removeLast();
        }
    }
}
