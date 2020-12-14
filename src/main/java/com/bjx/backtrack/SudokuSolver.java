package com.bjx.backtrack;

/**
 * @author FL8000
 * ��дһ������ͨ�����ո�������������⡣
 *
 * һ�������Ľⷨ����ѭ���¹���
 *
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 * �հ׸��� '.' ��ʾ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sudoku-solver
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // ��ٵ����һ�еĻ��ͻ�����һ�����¿�ʼ��
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // �ҵ�һ�����н⣬���� base case
            return true;
        }

        if (board[i][j] != '.') {
            // �����Ԥ�����֣������������
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // ����������Ϸ������֣�������
            if (!isValid(board, i, j, ch))
                continue;
            board[i][j] = ch;
            // ����ҵ�һ�����н⣬��������
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // ����� 1~9����Ȼû���ҵ����н⣬��·��ͨ
        return false;
    }
    boolean isValid(char[][] board, int i, int j,char ch) {
        for(int k = 0; k < 9;k++) {
            if(board[i][k] == ch) return false;
            if(board[k][j] == ch) return false;
            if(board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == ch) return false;
        }
        return true;
    }
}
