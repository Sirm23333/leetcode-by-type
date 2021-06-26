package medium;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 */
public class FindOrder {
    /**
     * dfs拓扑排序
     * 递归+栈
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }
        // 0-未访问 1-本轮dfs正在访问 2-已访问
        int[] visited = new int[numCourses];
        // 保存路径

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(!dfs(graph , i , visited , stack)){
                    return new int[0];
                }
            }
        }
        int[] rs = new int[numCourses];
        int i = 0;
        while(!stack.isEmpty()){
            rs[i++] = stack.pop();
        }
        return rs;
    }
    private boolean dfs(List<List<Integer>> graph, int i, int[] visited, Stack<Integer> stack) {
        visited[i] = 1;
        for(int edge : graph.get(i)){
            if(visited[edge] == 0){
                if(!dfs(graph , edge , visited , stack)){
                    return false;
                }
            }else if(visited[edge] == 1){
                return false;
            }
        }
        stack.push(i);
        visited[i] = 2;
        return true;
    }

    /**
     * bfs拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        // 记录入度
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        // bfs使用的队列
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int[] rs = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            rs[i++] = poll;
            for(int node : graph.get(poll)){
                inDegree[node]--;
                if(inDegree[node] == 0){
                    queue.add(node);
                }
            }
        }
        if(i != numCourses)
            return new int[0];
        return rs;
    }
}
