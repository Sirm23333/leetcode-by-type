package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 */
public class MinCostConnectPoints {
    /**
     * 使用Kruskal算法，并查集实现
     * Kruskal算法复杂度为 O(mlogm) m为边数量
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        UnionSet unionSet = new UnionSet(points.length);
        int[][] dis = new int[points.length][points.length];
        // 边list，元素为 {idx1,idx2,dis}
        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int dis1 = dis(points[i], points[j]);
                edgeList.add(new int[]{i,j,dis1});
            }
        }
        // 对边按距离排序
        edgeList.sort(Comparator.comparingInt(o -> o[2]));
        // kruskal算法
        int minCost = 0;
        int i = 0;
        while(unionSet.count > 1 && i < edgeList.size()){
            int[] edge = edgeList.get(i++);
            if(unionSet.find(edge[0]) != unionSet.find(edge[1])){
               // 两个点还没有连通，则选择这条边
                unionSet.union(edge[0] , edge[1]);
                minCost += edge[2];
            }
        }
        return minCost;
    }
    public int dis(int[] p1 , int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    class UnionSet{
        int[] parent;
        int[] rank;
        int count; // 连通图数
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
            count = len;
            for(int i = 0; i < len; i++){
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
                count--;
            }
        }
    }

    /**
     * prim算法
     * @param points
     * @return
     */
    public int minCostConnectPoints2(int[][] points) {
        int len = points.length;
        int[][] pointDis = new int[points.length][points.length];
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int dis1 = dis(points[i], points[j]);
                pointDis[i][j] = pointDis[j][i] = dis1;
            }
        }
        // 标志是否已选择，为true的为在已选集中，false为未选集
        boolean[] selected = new boolean[len];
        // dis[i]表示第i个节点，到可选集的任意节点的最短距离，如果到不了，则为MAX，如果在可选集则为-1
        int[] dis = new int[len];
        int minDis = 0;
        for(int i = 0; i < len; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < len; i++){
            int node = 0;
            int tmpMinDis ;
            if(i == 0){
                tmpMinDis = 0;
            }else {
                tmpMinDis = Integer.MAX_VALUE;
                for(int j = 0; j < len; j++){
                    if(!selected[j] && tmpMinDis > dis[j]){
                        tmpMinDis = dis[j];
                        node = j;
                    }
                }
            }
            // 选择node
            selected[node] = true;
            dis[node] = -1;
            // 更新dis
            for(int j = 0; j < len; j++){
                if(dis[j] > -1){
                    dis[j] = Math.min(dis[j] , pointDis[node][j]);
                }
            }
            minDis += tmpMinDis;
        }
        return minDis;
    }
}
