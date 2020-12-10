package backtrack;

/**
 * @author EnochStar
 * @title: CountNumbersWithUniqueDigits
 * @projectName leetcode_study
 * @description:
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/1014:17
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        if(n >= 10) return 0;
        boolean[] used = new boolean[10];
        return backtrack(used,0,n);
    }
    int backtrack(boolean[] used, int idx,int n){
        int count = 0;
        if(idx != n) {
            for(int i = 0;i < 10;i++) {
                if(used[i]) continue;
                if(i == 0 && n > 1 && idx == 1) continue;
                used[i] = true;
                count += backtrack(used,idx+1,n) + 1;
                used[i] = false;
            }
        }
        return count;
    }
}
