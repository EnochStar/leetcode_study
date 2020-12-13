package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EnochStar
 * @title: BinaryWatch
 * @projectName leetcode_study
 * @description:
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 思路分析：两种方法 1、回溯法 2、暴力解法
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020/12/13 10:16
 */
public class BinaryWatch {
    // 回溯
    // List<String> list = new ArrayList();
    // private int[] watch;
    // public List<String> readBinaryWatch(int num) {
    //     watch = new int[] {1,2,4,8,1,2,4,8,16,32};
    //     backtrack(num,0,0,0,0);
    //     return list;
    // }
    // void backtrack(int num, int count, int idx, int hour, int minute) {
    //     if(hour > 11 || minute > 59) {
    //         return;
    //     }
    //     if(count == num) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(hour).append(":");
    //         if(minute < 10){
    //             sb.append("0").append(minute);
    //         }else{
    //             sb.append(minute);
    //         }
    //         list.add(sb.toString());
    //         return;
    //     }
    //     if(idx == watch.length) return;
    //     backtrack(num,count,idx + 1,hour,minute);
    //     if(idx <= 3) {
    //         hour += watch[idx];
    //     } else {
    //         minute += watch[idx];
    //     }
    //     backtrack(num,count + 1,idx + 1,hour,minute);
    // }

    //暴力
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < 12;i++) {
            for (int j = 0;j < 60;j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(":");
                    if (j < 10){
                        sb.append("0").append(j);
                    }else {
                        sb.append(j);
                    }
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}
