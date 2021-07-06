package hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1168. 水资源分配优化
 * 村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
 *
 * 对于每个房子 i，我们有两种可选的供水方案：
 *
 * 一种是直接在房子内建造水井，成本为 wells[i]；
 * 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[i] = [house1, house2, cost] 代表用管道将 house1 和 house2 连接在一起的成本。当然，连接是双向的。
 * 请你帮忙计算为所有房子都供水的最低总成本。
 *
 * 1 <= n<= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/optimize-water-distribution-in-a-village
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MinCostToSupplyWater {
    class UnionSet{
        int[] parent;
        int[] rank;
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
            init();
        }
        public void init(){
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int i){
            if(parent[i] == i)
                return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }
        public void union(int i, int j){
            int pi = find(i);
            int pj = find(j);
            if(pi != pj){
                if(rank[pi] > rank[pj])
                    parent[pj] = pi;
                else if(rank[pi] < rank[pj])
                    parent[pi] = pj;
                else {
                    parent[pj] = pi;
                    rank[pi]++;
                }
            }
        }
    }
    public int minCostToSupplyWater2(int n, int[] wells, int[][] pipes) {
        int[][] newPipes = new int[pipes.length + n][3];
        System.arraycopy(pipes,0,newPipes,0,pipes.length);
        for(int i = pipes.length; i < pipes.length + n; i++){
            newPipes[i] = new int[]{i - pipes.length + 1 , 0 , wells[i - pipes.length]};
        }
        Arrays.sort(newPipes , Comparator.comparingInt(o -> o[2]));
        UnionSet unionSet = new UnionSet(newPipes.length);
        int sum = 0 , i = 0;
        int value = 0;
        while(sum < n  && i < pipes.length + n ){
            if(unionSet.find(pipes[i][0]) != unionSet.find(pipes[i][1])){
                unionSet.union(pipes[i][0],pipes[i][1]);
                value += pipes[i][2];
                sum++;
            }
            i++;
        }
        return value;
    }
    /**
     * prim
     * @param n
     * @param wells
     * @param pipes
     * @return
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // 将水井转换为通道，假设有一个成本为0的水井，其连接到其他水井i的通道成本为wells[i]
        int[][] newPipes = new int[pipes.length + n][3];
        System.arraycopy(pipes,0,newPipes,0,pipes.length);
        for(int i = pipes.length; i < pipes.length + n; i++){
            newPipes[i] = new int[]{i - pipes.length + 1 , 0 , wells[i - pipes.length]};
        }
        // prim算法
        // 建图
        int[][] grids = new int[n + 1][n + 1];
        int value = 0;
        for(int i = 0; i < n + 1; i ++){
            for(int j = 0; j < n + 1; j++){
                grids[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] pipe : newPipes){
            grids[pipe[0]][pipe[1]] = pipe[2];
            grids[pipe[1]][pipe[0]] = pipe[2];
        }
        boolean[] selected = new boolean[n + 1];
        int[] dis = new int[n + 1];
        for(int i = 0 ; i< n+1; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        // 先选择节点0
        selected[0] = true;
        for(int i = 1; i < n + 1; i++){
            dis[i] = grids[0][i];
        }
        for(int i = 1; i < n + 1; i++){
            int node = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n + 1; j++){
                if(!selected[j] && dis[j] < min){
                    min = dis[j];
                    node = j;
                }
            }
            // node肯定为合法的（题目规定）
            selected[node] = true;
            value += dis[node];
            for(int j = 0; j < n + 1; j++){
                dis[j] = Math.min(dis[j] , grids[node][j]);
            }
        }
        return value;
    }
}
