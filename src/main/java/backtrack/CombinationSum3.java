package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 找出所有相加之和为   n 的   k   个数的组合。组合中只允许含有 1 -   9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。   
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
