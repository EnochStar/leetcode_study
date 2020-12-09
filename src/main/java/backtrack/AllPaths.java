package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author EnochStar
 * @title: AllPaths
 * @projectName leetcode_study
 * @description: 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 *
 *
 * 示例 1：
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * 示例 2：
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
