package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
