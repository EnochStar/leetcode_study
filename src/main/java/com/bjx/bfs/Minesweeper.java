package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: Minesweeper
 * @projectName leetcode_study
 * @description: 
 * ������һ������ɨ����Ϸ��
 *
 * ����һ��������Ϸ��Ķ�ά�ַ����� 'M' ����һ��δ�ڳ��ĵ��ף�'E' ����һ��δ�ڳ��Ŀշ��飬'B' ����û�����ڣ��ϣ��£����ң�������4���Խ��ߣ����׵����ڳ��Ŀհ׷��飬���֣�'1' �� '8'����ʾ�ж��ٵ�����������ڳ��ķ������ڣ�'X' ���ʾһ�����ڳ��ĵ��ס�
 *
 * ���ڸ���������δ�ڳ��ķ����У�'M'����'E'������һ�����λ�ã��к������������������¹��򣬷�����Ӧλ�ñ�������Ӧ����壺
 *
 * ���һ�����ף�'M'�����ڳ�����Ϸ�ͽ�����- ������Ϊ 'X'��
 * ���һ��û�����ڵ��׵Ŀշ��飨'E'�����ڳ����޸���Ϊ��'B'�����������к������ڵ�δ�ڳ����鶼Ӧ�ñ��ݹ�ؽ�¶��
 * ���һ��������һ���������ڵĿշ��飨'E'�����ڳ����޸���Ϊ���֣�'1'��'8'������ʾ���ڵ��׵�������
 * ����ڴ˴ε���У����޸��෽��ɱ���¶���򷵻���塣
 *  
 *
 * ʾ�� 1��
 *
 * ����: 
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * ���: 
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * ����:
 *
 * ʾ�� 2��
 *
 * ����: 
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * ���: 
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * ����:
 *
 *  
 *
 * ע�⣺
 *
 * �������Ŀ��͸ߵķ�ΧΪ [1,50]��
 * �����λ��ֻ����δ���ڳ��ķ��� ('M' ���� 'E')����Ҳ��ζ��������ٰ���һ���ɵ���ķ��顣
 * ������岻������Ϸ������״̬�����е����ѱ��ڳ�����
 * �������δ�ἰ�Ĺ�������������пɱ����ԡ����磬����Ϸ����ʱ�㲻��Ҫ�ڳ����е��ף��������������Ӯ����Ϸ���Ƿ���������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minesweeper
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/18 14:58
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        dfs(board, x, y);
        return board;
    }

    int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E')  return;

        int num = getNumsOfBombs(board, x, y);

        if (num == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                dfs(board, nx, ny);
            }
        } else {
            board[x][y] = (char)('0' + num);
        }

    }

    private int getNumsOfBombs(char[][] board, int x, int y) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)    continue;
            if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                num++;
            }
        }
        return num;
    }
}