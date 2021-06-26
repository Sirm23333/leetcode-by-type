package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class CanFinish {
    /**
     * 拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> outList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            outList.add(new ArrayList<>());
        }
        for(int[] record : prerequisites){
            outList.get(record[0]).add(record[1]);
            inDegree[record[1]]++;
        }
        Set<Integer> selected = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0 && selected.add(i)){
                for(int out : outList.get(i)){
                    inDegree[out]--;
                }
                i = -1;
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] > 0){
                return false;
            }
        }
        return true;
    }
    /**
     * dfs找环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> outList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            outList.add(new ArrayList<>());
        }
        for(int[] record : prerequisites){
            outList.get(record[0]).add(record[1]);
        }
        // 0 无访问 1 被当前轮dfs遍历 2 被其他轮dfs遍历
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(!dfs(outList , i , visited)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> graph, int i , int[] visited){
        if(visited[i] == 1)
            return false;
        if(visited[i] == 0){
            visited[i] = 1;
            for(int record : graph.get(i)){
                if(!dfs(graph , record , visited)){
                    return false;
                }
            }
            visited[i] = 2;
        }
        return true;
    }
}
