package every;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * 题目分析：给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * https://leetcode-cn.com/problems/insert-interval/
 * ---------------------------------------------------------------------------------------
 * 分析：遍历分析即可，主要在于逻辑考量。与区间的合并类似。
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> list = new ArrayList();
        for(int[] interval : intervals){
            // 向右无交集
            if(interval[0] > right){
                if(!placed){
                    list.add(new int[]{left,right});
                    placed = true;
                }
                list.add(interval);
            }else if(interval[1] >= left){
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }else{
                list.add(interval);
            }
        }
        if(!placed){
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
