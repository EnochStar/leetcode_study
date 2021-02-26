package com.bjx.bfs;

/**
 * @author EnochStar
 * @title: SlidingPuzzle
 * @projectName leetcode_study
 * @description:
 * ��һ�� 2 x 3 �İ��ϣ�board���� 5 ��ש�ߣ������� 1~5 ����ʾ, �Լ�һ���ȱ�� 0 ����ʾ.
 *
 * һ���ƶ�����Ϊѡ�� 0 ��һ�����ڵ����֣��������ң����н���.
 *
 * ���յ��� board �Ľ���� [[1,2,3],[4,5,0]] �հ屻�⿪��
 *
 * ����һ���հ�ĳ�ʼ״̬���������ٿ���ͨ�����ٴ��ƶ��⿪�հ壬������ܽ⿪�հ壬�򷵻� -1 ��
 *
 * ʾ����
 *
 * ���룺board = [[1,2,3],[4,0,5]]
 * �����1
 * ���ͣ����� 0 �� 5 ��1 �����
 * ���룺board = [[1,2,3],[5,4,0]]
 * �����-1
 * ���ͣ�û�а취����հ�
 * ���룺board = [[4,1,2],[5,0,3]]
 * �����5
 * ���ͣ�
 * ��������հ�������ƶ������� 5 ��
 * һ���ƶ�·��:
 * ��δ�ƶ�: [[4,1,2],[5,0,3]]
 * �ƶ� 1 ��: [[4,1,2],[0,5,3]]
 * �ƶ� 2 ��: [[0,1,2],[4,5,3]]
 * �ƶ� 3 ��: [[1,0,2],[4,5,3]]
 * �ƶ� 4 ��: [[1,2,0],[4,5,3]]
 * �ƶ� 5 ��: [[1,2,3],[4,5,0]]
 * ���룺board = [[3,2,4],[1,5,0]]
 * �����14
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sliding-puzzle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/26 14:52
 */
public class SlidingPuzzle {
    int[][] move = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {
        char[] cs = new char[6];
        int index = 0;
        for(int[] rows : board) {
            for(int row : rows) {
                cs[index++] = (char)('0' + row);
            }
        }
        String s = new String(cs);
        String target = "123450";
        Deque<String> deque = new ArrayDeque();
        Set<String> visited = new HashSet();
        deque.offerFirst(s);
        int step = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();
            while(size-- > 0) {
                String tmp = deque.pollFirst();
                if(tmp.equals(target)) return step;
                int zeroIdx = tmp.indexOf('0');
                for(int next : move[zeroIdx]) {
                    String newS = changeStr(tmp,zeroIdx,next);
                    if(!visited.contains(newS)) {
                        visited.add(newS);
                        deque.offerLast(newS);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public String changeStr(String s,int src,int tar) {
        char[] c = s.toCharArray();
        char tmp = c[src];
        c[src] = c[tar];
        c[tar] = tmp;
        return new String(c);
    }
}
