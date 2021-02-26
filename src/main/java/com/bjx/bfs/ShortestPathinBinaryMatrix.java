package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: ShortestPathinBinaryMatrix
 * @projectName leetcode_study
 * @description: 
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *  
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
