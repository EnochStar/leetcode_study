package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author EnochStar
 * @title: AllPaths
 * @projectName leetcode_study
 * @description: ��һ���� n �����������޻�ͼ���ҵ����д� 0 �� n-1 ��·�����������Ҫ��˳��
 *
 * ��ά����ĵ� i �������еĵ�Ԫ����ʾ����ͼ�� i �Ž�����ܵ������һЩ��㣨����ע������ͼ���з���ģ����涨�� a��b ��Ͳ��ܴ� b��a ���վ���û����һ������ˡ�
 *
 *
 * ʾ�� 1��
 *
 * ���룺graph = [[1,2],[3],[3],[]]
 * �����[[0,1,3],[0,2,3]]
 * ���ͣ�������·�� 0 -> 1 -> 3 �� 0 -> 2 -> 3
 *
 * ʾ�� 2��
 *
 * ���룺graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * �����[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/910:49
 */
public class AllPaths {
    List<List<Integer>> res = new ArrayList();
    int ed;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> list = new LinkedList();
        list.add(0);
        ed = graph.length - 1;
        backtrack(graph,list,0);
        return res;
    }
    void backtrack(int[][] graph, LinkedList<Integer> list, Integer num) {
        if(num == ed) {
            res.add(new ArrayList(list));
            return;
        }
        for(Integer index : graph[num]) {
            list.add(index);
            backtrack(graph,list,index);
            list.removeLast();
        }
    }
}
