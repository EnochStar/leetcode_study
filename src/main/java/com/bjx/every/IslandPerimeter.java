package com.bjx.every;

/**
 * @author FL8000
 * ��Ŀ����������һ������ 0 �� 1 �Ķ�ά�����ͼ������ 1 ��ʾ½�أ�0 ��ʾˮ��
 *
 * �����еĸ���ˮƽ�ʹ�ֱ�����������Խ��߷�������������������ˮ��ȫ��Χ��������ǡ����һ������
 * ������˵��һ��������ʾ½�صĸ���������ɵĵ��죩��
 * ������û�С������������� ָˮ���ڵ����ڲ��Ҳ��͵�����Χ��ˮ�������������Ǳ߳�Ϊ 1 �������Ρ�
 * ����Ϊ�����Σ��ҿ�Ⱥ͸߶Ⱦ������� 100 ���������������ܳ���
 *
 * ���ӣ�https://leetcode-cn.com/problems/island-perimeter
 * ---------------------------------------------------------------
 * ���������ܳ������ж��ܱ�ˮ��ͱ߽���������ڱ߽������������Ⱦ������ķ��������ȵݹ���ã�����dfs��ͷ���ж�
 *
 * ����ģ��
 * // ������λ�������Ե�����
 * void dfs(int[][] grid, int r, int c) {
 *     // �����겻�Ϸ���ֱ�ӷ���
 *     if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
 *         return;
 *     }
 *     // ���÷����ǵ��죬ֱ�ӷ���
 *     if (grid[r][c] != 1) {
 *         return;
 *     }
 *     dfs(grid, r - 1, c);
 *     dfs(grid, r + 1, c);
 *     dfs(grid, r, c - 1);
 *     dfs(grid, r, c + 1);
 * }
 *
 * �����������ѭ�����������Ҫ���߹���·������ǣ����Խ�������ֵ�ı䣬�����ô���һ���߼��������ж�
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return 1;
        }
        if(grid[x][y] == 0){
            return 1;
        }
        if(grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 2;
        return dfs(grid,x + 1,y) + dfs(grid,x - 1,y) + dfs(grid,x,y + 1) + dfs(grid,x,y-1);
    }
}
