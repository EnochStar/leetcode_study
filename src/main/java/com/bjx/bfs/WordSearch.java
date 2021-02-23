package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: WordSearch
 * @projectName leetcode_study
 * @description: 
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 *
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 *
 *  
 *
 * ʾ��:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * ���� word = "ABCCED", ���� true
 * ���� word = "SEE", ���� true
 * ���� word = "ABCB", ���� false
 *  
 *
 * ��ʾ��
 *
 * board �� word ��ֻ������д��СдӢ����ĸ��
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/word-search
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
