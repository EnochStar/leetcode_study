package com.bjx.unionfind;

/**
 * @author EnochStar
 * @title: SurroundedRegions
 * @projectName leetcode_study
 * @description: 
 * ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
 *
 * �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
 *
 * ʾ��:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * ������ĺ����󣬾����Ϊ��
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * ����:
 *
 * ��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'�� �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/surrounded-regions
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
