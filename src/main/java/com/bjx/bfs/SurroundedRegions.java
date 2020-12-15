package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: SurroundedRegions
 * @projectName leetcode_study
 * @description: 
 * ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
 *
 * �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
 *
 * ʾ��:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * ������ĺ����󣬾����Ϊ��
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * ����:
 *
 * ��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'�� �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
 *
 * ˼·��1����ʼ���߽�  O Ϊ��1��
 *      2����1���й�ȱ��� ��������O ��Ϊ ��1��
 *      3��������ά���� O ΪX
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/surrounded-regions
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
