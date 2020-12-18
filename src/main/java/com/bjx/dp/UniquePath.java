package com.bjx.dp;

/**
 * @author EnochStar
 * @title: UniquePath
 * @projectName leetcode_study
 * @description:
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 *
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 *
 *
 *
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * �����2
 * ���ͣ�
 * 3x3 ��������м���һ���ϰ��
 * �����Ͻǵ����½�һ���� 2 ����ͬ��·����
 * 1. ���� -> ���� -> ���� -> ����
 * 2. ���� -> ���� -> ���� -> ����
 * ʾ�� 2��
 *
 *
 * ���룺obstacleGrid = [[0,1],[0,0]]
 * �����1
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/unique-paths-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �Զ�����   -----   �� ����¼
 * �Ե�����
 * @date 2020/12/18 17:28
 */
public class UniquePath {
    boolean[][] visited;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        visited[0][0] = true;
        return countRoad(obstacleGrid, 0, 0);
    }
    public int countRoad(int[][] obstacleGrid,int row,int col){
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == '1')
            return 0;
        if(visited[row][col]) return 0;
        else{

        }
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return 1;
        }
        int count = countRoad(obstacleGrid,row + 1,col) + countRoad(obstacleGrid,row,col + 1);
        return count;
    }
}
