package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: NumberofIslands
 * @projectName leetcode_study
 * @description: 
 * ����һ����  '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 *
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 *
 * ���⣬����Լ��������������߾���ˮ��Χ��
 *
 *   
 *
 * ʾ�� 1��
 *
 * ���룺grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * �����1
 * ʾ�� 2��
 *
 * ���룺grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * �����3
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-islands
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
