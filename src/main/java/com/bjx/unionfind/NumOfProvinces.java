package com.bjx.unionfind;

/**
 * @author EnochStar
 * @title: NumOfProvinces
 * @projectName leetcode_study
 * @description: 
 * �� n �����У�����һЩ�˴���������һЩû��������������� a ����� b ֱ���������ҳ��� b ����� c ֱ����������ô���� a ����� c ���������
 *
 * ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�
 *
 * ����һ�� n x n �ľ��� isConnected ������ isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ���������� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������
 *
 * ���ؾ����� ʡ�� ��������
 *
 *  
 *
 * ʾ�� 1��
 *
 *
 * ���룺isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * �����2
 * ʾ�� 2��
 *
 *
 * ���룺isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * �����3
 *  
 *
 * ��ʾ��
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] Ϊ 1 �� 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-provinces
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/24 14:50
 */
public class NumOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i < n - 1;i++) {
            for(int j = i + 1;j < n;j++) {
                if(isConnected[i][j] == 1)
                    uf.union(i,j);
            }
        }
        return uf.count();
    }
    class UnionFind{
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i = 0;i < n;i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while(parent[root] != root) {
                root = parent[root];
            }
            while(parent[p] != p) {
                int x = p;
                p = parent[p];
                parent[x] = root;
            }
            return root;
        }

        public void union(int x,int y) {
            int end1 = find(x);
            int end2 = find(y);
            if(end1 == end2) return;
            parent[end2] = end1;
            count--;
        }

        public int count() {
            return count;
        }
    }
}
