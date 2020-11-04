package every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FL8000
 * 题目分析：给出一个区间的集合，请合并所有重叠的区间。
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * ------------------------------------------------------
 * 分析：需要先对数组进行排序，然后对区间进行判断，再列表转数组
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1;i< intervals.length;i++){
            if (temp[1]<intervals[i][0]){
                list.add(temp);
                temp=intervals[i];
            }else if (temp[1]<intervals[i][1]){
                temp[1] = intervals[i][1];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][2]);
    }
}
