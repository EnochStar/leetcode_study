package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 * ����һ������ n���������в�ͬ��n �ʺ�����Ľ��������
 *
 * ÿһ�ֽⷨ����һ����ȷ��n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 *
 * 
 *
 * ʾ����
 *
 * ���룺4
 * �����[
 *  [".Q..",  // �ⷨ 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // �ⷨ 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * ����: 4 �ʺ��������������ͬ�Ľⷨ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/n-queens
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NQueens {
    List<List<String>> res = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        // ��ʼ������
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board,0);
        return res;
    }
    // ����ģ��
    void backtrack(char[][] board, int row) {
        if(row == board.length) {
            res.add(convert(board));
            return;
        }
        int n = board[row].length;
        for(int j = 0;j < n;j++) {
            if(!isValid(board, row, j)) {
                continue;
            }
            board[row][j] = 'Q';
            backtrack(board,row + 1);
            board[row][j] = '.';
        }
    }
    // ��֦
    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // ������Ƿ��лʺ����ͻ
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // ������Ϸ��Ƿ��лʺ����ͻ
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // ������Ϸ��Ƿ��лʺ����ͻ
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    // ֱ�ӽ���ά�������ת����String  ֮ǰ��֪������������
    List<String> convert(char[][] board) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
}
