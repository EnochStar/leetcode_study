package com.bjx.dp;

/**
 * @author EnochStar
 * @title: UniquePath
 * @projectName leetcode_study
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 自顶而下   -----   》 备忘录
 * 自底向上
 * @date 2020/12/18 17:28
 */
public class UniquePath {
    boolean[][] visited;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        visited[0][0] = true;
        return countRoad(obstacleGrid, 0, 0);
    }
    public int countRoad(int[][] obstacleGrid,int row,int col){
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == '1')
            return 0;
        if(visited[row][col]) return 0;
        else{

        }
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return 1;
        }
        int count = countRoad(obstacleGrid,row + 1,col) + countRoad(obstacleGrid,row,col + 1);
        return count;
    }
}
