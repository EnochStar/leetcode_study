package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
