package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 */
public class FindCheapestPrice {
    /**
     * dfs超时
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] grids = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grids[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] flight : flights){
            grids[flight[0]][flight[1]] = flight[2];
        }
        boolean[] visited = new boolean[n];
        dfs(n,visited, grids, src,  dst, k, 1 , 0 );
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
    int rs = Integer.MAX_VALUE;
    // sum:遍历过的节点数量
    public void dfs(int n, boolean[] visited ,int[][] grids, int idx, int dst , int k, int sum, int curValue){
        visited[idx] = true;
        if(idx == dst){
            rs = Math.min(rs,curValue);
        }else if(curValue < rs){
            for(int i = 0; i < n; i++){
                if(!visited[i] && grids[idx][i] != Integer.MAX_VALUE && sum < k + 2){
                    dfs(n , visited , grids, i , dst , k, sum + 1, curValue + grids[idx][i]);
                }
            }
        }
        visited[idx] = false;
    }

    /**
     * Bellman-ford算法
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int[] p = new int[n];
        int[] c ;
        for(int i = 0; i < n; i++){
            p[i] = Integer.MAX_VALUE;
        }
        p[src] = 0;
        c = Arrays.copyOf(p,p.length);
        // 转机k次即松弛k+1次（松弛一次即增加一条边）
        for(int i = 0; i < k + 1; i++){ // 松弛k+1次
            boolean end = true;
            for(int[] flight : flights){
                if(p[flight[0]] != Integer.MAX_VALUE && p[flight[0]] + flight[2] < c[flight[1]]){
                    end = false;
                    c[flight[1]] = p[flight[0]] + flight[2];
                }
            }
            p = Arrays.copyOf(c,c.length);
            if(end)
                break;
        }
        return c[dst] == Integer.MAX_VALUE ? -1 : c[dst];
    }

}
