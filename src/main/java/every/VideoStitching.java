package every;

import java.util.Arrays;

/**
 * @author FL8000
 * 题目描述：
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为T秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段clips[i]都用区间进行表示：开始于clips[i][0]并于clips[i][1]结束。我们甚至可以对这些片段自由地再剪辑，例如片段[0, 7]可以剪切成[0, 1] +[1, 3] + [3, 7]三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回-1 。
 * ----------------------------------------------------------------------------------------------------------------
 * 分析:
 * 贪心算法 记录给定碎片中 左碎片对应的最远右碎片。
 * 然后重新遍历。last存储当前所能到达的最远距离。pre存储到达的一个区间。当到达该区间时，num+1
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0;
        int num = 0;
        int pre = 0;
        // 记录各个左位置 所能达到的最远的右位置
        for(int[] clip : clips){
            if(clip[0] < T){
                maxn[clip[0]] = Math.max(maxn[clip[0]],clip[1]);
            }
        }
        for(int i = 0;i < T;i++){
            last = Math.max(maxn[i],last);
            if(i == last){
                return -1;
            }
            if(i == pre){
                num++;
                pre = last;
            }
        }
        return num;
    }
}
