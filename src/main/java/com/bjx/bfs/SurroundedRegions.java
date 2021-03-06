package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: SurroundedRegions
 * @projectName leetcode_study
 * @description: 
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 思路：1、初始化边界  O 为‘1’
 *      2、对1进行广度遍历 遍历到的O 变为 “1”
 *      3、遍历二维数组 O 为X
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/15 17:51
 */
public class SurroundedRegions {
    int row,col;
    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        for(int i = 0;i < row;i++) {
            dfs(board,i,0);
            dfs(board,i,col - 1);
        }
        for(int j = 0;j < col;j++) {
            dfs(board,0,j);
            dfs(board,row - 1,j);
        }
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[i].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    void dfs(char[][] board,int x,int y) {
        if(x < 0 || y < 0 || x >= row || y >= col || board[x][y] != 'O') return;
        board[x][y] = '1';
        dfs(board,x - 1,y);
        dfs(board,x + 1,y);
        dfs(board,x,y - 1);
        dfs(board,x,y + 1);
    }
}
