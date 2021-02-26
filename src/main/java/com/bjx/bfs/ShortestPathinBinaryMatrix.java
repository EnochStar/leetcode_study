package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: ShortestPathinBinaryMatrix
 * @projectName leetcode_study
 * @description: 
 * ����һ�� n x n �Ķ����ƾ��� grid �У����ؾ�������� ��ͨ·�� �ĳ��ȡ����������������·�������� -1 ��
 *
 * �����ƾ����е� ��ͨ·�� ��һ���� ���Ͻ� ��Ԫ�񣨼���(0, 0)���� ���½� ��Ԫ�񣨼���(n - 1, n - 1)����·������·��ͬʱ��������Ҫ��
 *
 * ·��;�������е�Ԫ�񶼵�ֵ���� 0 ��
 * ·�����������ڵĵ�Ԫ��Ӧ���� 8 ������֮һ ����ͨ��������������Ԫ֮��˴˲�ͬ�ҹ���һ���߻���һ���ǣ���
 * ��ͨ·���ĳ��� �Ǹ�·��;���ĵ�Ԫ��������
 *
 *  
 *
 * ʾ�� 1��
 *
 *
 * ���룺grid = [[0,1],[1,0]]
 * �����2
 * ʾ�� 2��
 *
 *
 * ���룺grid = [[0,0,0],[1,1,0],[1,1,0]]
 * �����4
 * ʾ�� 3��
 *
 * ���룺grid = [[1,0,0],[1,1,0],[1,1,0]]
 * �����-1
 *  
 *
 * ��ʾ��
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] Ϊ 0 �� 1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/26 12:04
 */
public class ShortestPathinBinaryMatrix {
    int[] dx = new int[] {0,0,1,1,-1,-1,1,-1};
    int[] dy = new int[] {-1,1,1,-1,1,-1,0,0};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int startX = 0,startY = 0,endX = grid.length - 1,endY = grid[0].length - 1;
        if(grid == null || grid.length == 0 || grid[0].length == 0
                || grid[startX][startY] == 1 || grid[endX][endY] == 1) {
            return -1;
        }
        Deque<int[]> deque = new ArrayDeque();
        deque.add(new int[] {0,0});
        grid[0][0] = 1;
        int path = 1;
        while(!deque.isEmpty()) {
            int size = deque.size();
            while(size-- > 0) {
                int[] cur = deque.pollFirst();
                int x = cur[0];
                int y = cur[1];
                if(x == endX && y == endY) {
                    return path;
                }
                for(int i = 0;i < 8;i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if(newX < 0 || newY < 0 || newX > endX || newY > endY || grid[newX][newY] == 1) {
                        continue;
                    }
                    deque.add(new int[]{newX,newY});
                    grid[newX][newY] = 1;
                }
            }
            path++;
        }
        return -1;
    }
}
