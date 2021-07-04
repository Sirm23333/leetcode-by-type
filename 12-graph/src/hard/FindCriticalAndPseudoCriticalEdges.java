package hard;

import java.util.*;

/**
 * 1489. 找到最小生成树里的关键边和伪关键边
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 *
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 *
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 */
public class FindCriticalAndPseudoCriticalEdges {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Map<int[],Integer> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            edgeMap.put(edges[i],i);
        }
        // 边排序
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        // Kruskal算法走起
        UnionSet unionSet = new UnionSet(n);
        List<List<Integer>> rs = new ArrayList<>();
        rs.add(new ArrayList<>());
        rs.add(new ArrayList<>());
        int sum = 0, i = 0;
        while(sum < n - 1 && i < n){

        }
        return rs;
    }
    class UnionSet{
        int[] parent;
        int[] rank;
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
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
