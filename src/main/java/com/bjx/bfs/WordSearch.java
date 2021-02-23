package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: WordSearch
 * @projectName leetcode_study
 * @description: 
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/23 15:09
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    flag = dfs(board,visited,word,0,i,j);
                    if(flag) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,boolean[][] visited,String word,int index,int row,int col) {
        if(index == word.length()) {
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if(board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean flag = dfs(board,visited,word,index + 1,row + 1,col) || dfs(board,visited,word,index + 1,row - 1,col)
                || dfs(board,visited,word,index + 1,row,col - 1) || dfs(board,visited,word,index + 1,row,col + 1);
        visited[row][col] = false;
        return flag;
    }
}
