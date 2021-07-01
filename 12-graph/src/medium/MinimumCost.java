package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1135. 最低成本联通所有城市
 * 想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
 *
 * 给你一些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 表示将城市 city1 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市 city1 和城市 city2 相连也同样意味着城市 city2 和城市 city1 相连）。
 *
 * 返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。该最小成本应该是所用全部连接代价的综合。如果根据已知条件无法完成该项任务，则请你返回 -1。
 *
 *
 */
public class MinimumCost {
    /**
     * kruskal算法
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        UnionSet unionSet = new UnionSet(n);
        int min = 0 , i = 0;
        while(unionSet.count > 1 && i < connections.length){
            if(unionSet.find(connections[i][0] - 1) != unionSet.find(connections[i][1] - 1)){
                unionSet.union(connections[i][0] - 1, connections[i][1] - 1);
                min += connections[i][2];
            }
            i++;
        }
        return unionSet.count == 1 ? min : -1;
    }

    /**
     * prim算法
     * 使用邻接矩阵存，内存超限
     * 使用HashMap邻接表存，时间超限
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost2(int n, int[][] connections) {
        // 建图
        Map<Integer, Map<Integer,Integer>> grid = new HashMap<>();
        for(int i = 0; i < n; i++){
            grid.put(i,new HashMap<>());
        }
        for(int[] connection : connections){
            grid.get(connection[0] - 1).put(connection[1] - 1,connection[2]);
            grid.get(connection[1] - 1).put(connection[0] - 1,connection[2]);
        }
        // 初始化
        boolean[] selected = new boolean[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // prim
        int minDis = 0;
        for(int i = 0; i < n; i++){
            int node = -1;
            int tmpMinDis = Integer.MAX_VALUE;
            // 选择放入已选集的node
            if(i == 0){
                node = 0;
                tmpMinDis = 0;
            }else {
                for(int j = 0; j < n; j++){
                    if(!selected[j] && tmpMinDis > distance[j]){
                        tmpMinDis = distance[j];
                        node = j;
                    }
                }
            }
            if(node == -1)
                return -1;
            // 放入已选集，更新distance
            selected[node] = true;
            distance[node] = -1;
            for (int j = 0; j < n; j++) {
                if(distance[j] > -1){
                    distance[j] = Math.min(distance[j] , grid.get(node).getOrDefault(j,Integer.MAX_VALUE));
                }
            }
            minDis += tmpMinDis;
        }
        return minDis;
    }
    class UnionSet{
        int[] parent;
        int[] rank;
        int count;
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
            count = len;
            for (int i = 0; i < len; i++) {
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
                count--;
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
}
