package medium;

/**
 * 1334. 阈值距离内邻居最少的城市
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 *
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 *
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 */
public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // 迭代用的保存当前最小距离的矩阵
        int[][] dist = new int[n][n];
        // parent[i][j]=k 记录从节点i到节点j的跳板节点k，即从i到j的路径为i->...->k->j
        int[][] parent = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j)
                    dist[i][j] =0;
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
        }
        for(int k = 0; k < n; k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i != j && dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        parent[i][j] = k;
                    }

                }
            }
        }
        int rsNode = -1, rsSum = n + 1;
        for(int i = 0; i < n; i++){
            int tmp = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    tmp++;
                }
            }
            if(tmp <= rsSum){
                rsSum = tmp;
                rsNode = i;
            }
        }
        return rsNode;
    }
}
