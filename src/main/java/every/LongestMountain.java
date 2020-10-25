package every;

/**
 * @author FL8000
 * 题目分析：我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i< B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉”的长度。
 *
 * 如果不含有 “山脉”则返回 0。
 *
 * -----------------------------------------------------------------------------------------------------
 * 分析：双指针方式，从数组第二个到倒数第二个为山顶，依次判断其长度
 */
public class LongestMountain {
    public int longestMountain(int[] A) {
        // 双指针
        // 边界
        int len = A.length;
        int ans = 0;
        if (len<3){
            return 0;
        }
        for (int i = 1; i < len-1; i++) {
            int l = i-1, r = i+1;
            if (A[i]>A[l]&&A[i]>A[r]){
                while(l>0&&A[l]>A[l-1]){
                    l--;
                }
                while(r<len-1&&A[r]>A[r+1]){
                    r++;
                }
                ans = Math.max(ans,r-l+1);
            }
        }
        return ans;
    }
}
