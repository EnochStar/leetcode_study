package com.bjx.unionfind;

/**
 * @author EnochStar
 * @title: SurroundedRegions
 * @projectName leetcode_study
 * @description: 
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/24 15:27
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummy = rows * cols;
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(node(i,j,cols),dummy);
                    }else{
                        if(i > 0 && board[i - 1][j] == 'O') {
                            uf.union(node(i,j,cols),node(i - 1,j,cols));
                        }
                        if(i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.union(node(i,j,cols),node(i + 1,j,cols));
                        }
                        if(j > 0 && board[i][j - 1] == 'O') {
                            uf.union(node(i,j,cols),node(i,j - 1,cols));
                        }
                        if(j < cols - 1 && board[i][j + 1] == 'O') {
                            uf.union(node(i,j,cols),node(i,j + 1,cols));
                        }
                    }
                }
            }
        }
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(uf.find(node(i,j,cols)) == uf.find(dummy)) {
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public int node(int row,int col,int len) {
        return row * len + col;
    }
    class UnionFind{
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i = 0;i < n;i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while(root != parent[root]) {
                root = parent[root];
            }
            while(p != parent[p]) {
                int x = p;
                p = parent[p];
                parent[x] = root;
            }
            return root;
        }

        public void union(int x,int y) {
            int endx = find(x);
            int endy = find(y);
            if(endx == endy) {
                return;
            }
            parent[endx] = endy;
            count--;
        }
        public int count() {
            return count;
        }
    }
}
