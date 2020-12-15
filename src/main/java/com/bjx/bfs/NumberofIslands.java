package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: NumberofIslands
 * @projectName leetcode_study
 * @description: 
 * 给你一个由  '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/15 18:56
 */
public class NumberofIslands {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        col = grid[0].length;
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                if(grid[i][j] == '1') count++;
                dfs(grid,i,j);
            }
        }
        return count;
    }
    void dfs(char[][] grid,int x,int y) {
        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] != '1') return;
        grid[x][y] = '2';
        dfs(grid,x - 1,y);
        dfs(grid,x + 1,y);
        dfs(grid,x,y - 1);
        dfs(grid,x,y + 1);
    }
}
