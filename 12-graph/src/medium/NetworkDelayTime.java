package medium;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 建图
        int[][] grids = new int[n+1][n+1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                grids[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] time : times){
            grids[time[0]][time[1]] = time[2];
        }
        // 标志是否已经找到最短路
        boolean[] visited = new boolean[n+1];
        // 最短路长度
        int[] dist = new int[n+1];
        // 节点最短路径的上一个节点
        int[] parent = new int[n+1];

        for(int i = 1; i < n + 1; i++){
           dist[i] = Integer.MAX_VALUE;
           parent[i] = -1;
        }
        dist[k] = 0;
        parent[k] = k;
        // n 次循环，每次确定一个点的最短路径
        for(int i = 0; i < n ; i++){
            int node = -1;
            int tmpMin = Integer.MAX_VALUE;
            for(int j = 1; j < n + 1; j++){
                if(!visited[j] && tmpMin > dist[j]){
                    node = j;
                    tmpMin = dist[j];
                }
            }
            if(node == -1){
                break;
            }
            // 选择node，更新数组
            visited[node] = true;
            for(int j = 1; j < n + 1; j++){
                if(!visited[j] && grids[node][j] != Integer.MAX_VALUE && dist[node] + grids[node][j] < dist[j]){
                    dist[j] = dist[node] + grids[node][j];
                    parent[j] = node;
                }
            }
        }
        int max = -1;
        for(int d : dist){
            max = Math.max(max,d);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
