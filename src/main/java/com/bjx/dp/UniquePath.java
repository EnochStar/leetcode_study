package com.bjx.dp;

/**
 * @author EnochStar
 * @title: UniquePath
 * @projectName leetcode_study
 * @description:
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
