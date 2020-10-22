package every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FL8000
 * 题目分析：
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * ----------------------------------------------------------------------------------------
 * 分析：
 * 遍历字符串，获取各个字符最后出现的位置。再次遍历，判断读取子串中是否达到最后出现的那个字符。然后截断。
 *
 * https://leetcode-cn.com/problems/partition-labels/comments/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] a = new int[26];
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList();
        for(int i = 0;i < S.length();i++){
            a[S.charAt(i) - 'a'] = i;
        }
        for(int i = 0;i < S.length();i++){
            end = Math.max(a[S.charAt(i) - 'a'], end);
            if(end == i){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
