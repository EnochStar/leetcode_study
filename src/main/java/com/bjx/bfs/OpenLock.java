package com.bjx.bfs;

import java.util.*;

/**
 * @author EnochStar
 * @title: OpenLock
 * @projectName leetcode_study
 * @description: 
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/14 9:21
 */
public class OpenLock {
    // public int openLock(String[] deadends, String target) {
    //     Set<String> set = new HashSet(Arrays.asList(deadends));
    //     Set<String> visited = new HashSet<>();
    //     Queue<String> queue = new LinkedList<>();
    //     String start = "0000";
    //     int depth = 0;
    //     if (set.contains(start)) return 0;
    //     queue.add(start);
    //     while (!queue.isEmpty()) {
    //         int sz = queue.size();
    //         for (int i = 0;i < sz; i++) {
    //             String cur = queue.poll();
    //             // 包含在deadends时 就无法更改锁
    //             if (set.contains(cur)) continue;
    //             if (cur.equals(target)) return depth;
    //             for (int j = 0;j < 4;j++) {
    //                 String fis = plusOne(cur,j);
    //                 if (!visited.contains(fis)) {
    //                     queue.add(fis);
    //                     visited.add(fis);
    //                 }
    //                 String sec = minusOne(cur,j);
    //                 if (!visited.contains(sec)) {
    //                     queue.add(sec);
    //                     visited.add(sec);
    //                 }
    //             }
    //         }
    //         depth++;
    //     }
    //     return -1;
    // }
    int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public String plusOne(String s,int index) {
        char[] c = s.toCharArray();
        if (c[index] == '9') c[index] = '0';
        else c[index]++;
        return new String(c);
    }
    public String minusOne(String s,int index) {
        char[] c = s.toCharArray();
        if (c[index] == '0') c[index] = '9';
        else c[index]--;
        return new String(c);
    }
}
