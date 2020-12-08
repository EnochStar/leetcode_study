package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EnochStar
 * @title: PermutationSequence
 * @projectName leetcode_study
 * @description: The set [1, 2, 3, ...,?n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 体会： 回溯的结果是有序的，可以根据树的层次进行剪枝（注意 回溯形成的树本身就是一个完美二叉树）
 * @date 2020/12/814:05
 */
public class PermutationSequence {
    int n;
    int k;
    int[] fac;
    boolean[] used;
    String res;
    public String getPermutation(int n, int k) {
        this.k = k;
        this.n = n;
        factorial(n);
        used = new boolean[n + 1];
        backtrack(0, n, new StringBuilder());
        return res;
    }
    void backtrack(int index, int n, StringBuilder sb) {
        if(index == n) {
            res = sb.toString();
            return;
        }
        // 剩余的层数对应的阶
        int cnt = fac[n - 1 - index];
        for(int i = 1;i <= n;i++) {
            if(used[i]) continue;
            if(k > cnt) {
                k -= cnt;
                continue;
            }
            sb.append(i);
            used[i] = true;
            backtrack(index + 1,n,sb);
            return;
        }
    }
    public void factorial(int n) {
        fac = new int[n + 1];
        fac[0] = 1;
        for(int i = 1;i <= n;i++) {
            fac[i] = fac[i - 1] * i;
        }
    }
}
