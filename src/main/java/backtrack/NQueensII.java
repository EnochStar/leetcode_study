package backtrack;

/**
 * @author EnochStar
 * @title: NQueensII
 * @projectName leetcode_study
 * @description: n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 *
 *
 * ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n������ n �ʺ�ͬ�Ľ��������������
 *
 * ʾ��:
 *
 * ����: 4
 * ���: 2
 * ����: 4 �ʺ������������������ͬ�Ľⷨ��
 * [
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
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/n-queens-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/1014:16
 */
public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board,0);
        return count;
    }
    void backtrack(char[][] board, int row) {
        if(row >= board.length) {
            count++;
            return;
        }
        for(int i = 0;i < board.length;i++) {
            if(!isValid(board,row,i)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(board,row + 1);
            board[row][i] = '.';
        }
    }
    boolean isValid(char[][] board,int row,int col) {
        // �е��ж�
        for(int i = row;i >= 0;i--) {
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row,j = col;i >= 0 && j >= 0;i--,j--) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row,j = col; i >=0 && j <board.length;i--,j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
