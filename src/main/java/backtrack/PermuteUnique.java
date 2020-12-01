package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这题的关键在于如何剪枝。
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
