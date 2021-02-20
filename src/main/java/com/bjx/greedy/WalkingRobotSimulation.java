package com.bjx.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EnochStar
 * @title: WalkingRobotSimulation
 * @projectName leetcode_study
 * @description: 
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 *  
 * 注意：
 *
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *  
 *
 * 示例 1：
 *
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 *
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/20 11:32
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0,y = 0,result = 0;
        Set<String> set = new HashSet();
        for(int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        int[] dx = new int[] {0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        int direction = 0;
        for(int com : commands) {
            if(com == -2) {
                direction = (direction + 3) % 4;
            }else if(com == -1) {
                direction = (direction + 1) % 4;
            }else{
                for(int i = 1;i <= com;i++) {
                    x = dx[direction] + x;
                    y = dy[direction] + y;
                    if(set.contains(x + "," + y))
                        break;
                }
                result = Math.max(result,x * x + y * y);
            }
        }
        return result;
    }
}
