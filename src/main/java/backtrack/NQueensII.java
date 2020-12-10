package backtrack;

/**
 * @author EnochStar
 * @title: NQueensII
 * @projectName leetcode_study
 * @description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        // 列的判断
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
