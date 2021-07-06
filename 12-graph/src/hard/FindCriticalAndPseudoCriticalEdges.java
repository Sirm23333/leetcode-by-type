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
        // Kruskal算法走起，求出最小生成树的权值
        UnionSet unionSet = new UnionSet(n);
        List<List<Integer>> rs = new ArrayList<>();
        rs.add(new ArrayList<>());
        rs.add(new ArrayList<>());
        int value = 0, i = 0;
        for (int[] edge : edges) {
            if(unionSet.find(edge[0]) != unionSet.find(edge[1])){
                unionSet.union(edge[0],edge[1]);
                value += edge[2];
                i++;
            }
            if(i == n - 1)
                break;
        }
        // 枚举寻找关键边，强制不选一条边，如果value变大，则为关键边
        int tmpValue = 0 , tmpI = 0;
        Set<Integer> keyEdgeSet = new HashSet<>();
        for(int a = 0; a < edges.length; a++){
            tmpI = 0;
            tmpValue = 0;
            unionSet.init();
            for(int b = 0; b < edges.length; b++){
                if(a == b)
                    continue;
                if(unionSet.find(edges[b][0]) != unionSet.find(edges[b][1])){
                    unionSet.union(edges[b][0],edges[b][1]);
                    tmpValue += edges[b][2];
                    tmpI++;
                }
                if(tmpI == n - 1)
                    break;
            }
            if(tmpI != n - 1 || tmpValue > value){
                rs.get(0).add(edgeMap.get(edges[a]));
                keyEdgeSet.add(a);
            }
        }
        // 枚举伪关键边，强制选择一条边，如果value不变且该边不是关建边，则为伪关建边
        for(int a = 0; a < edges.length; a++){
            tmpI = 0;
            tmpValue = 0;
            unionSet.init();
            if(!keyEdgeSet.contains(a)){
                unionSet.union(edges[a][0],edges[a][1]);
                tmpValue += edges[a][2];
                tmpI++;
                for(int b = 0; b < edges.length; b++){
                    if(unionSet.find(edges[b][0]) != unionSet.find(edges[b][1])){
                        unionSet.union(edges[b][0],edges[b][1]);
                        tmpValue += edges[b][2];
                        tmpI++;
                    }
                    if(tmpI == n - 1)
                        break;
                }
                if(tmpI == n - 1 && tmpValue == value){
                    rs.get(1).add(edgeMap.get(edges[a]));
                }
            }
        }
        return rs;
    }
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

    public static void main(String[] args) {

        FindCriticalAndPseudoCriticalEdges f = new FindCriticalAndPseudoCriticalEdges();
        f.findCriticalAndPseudoCriticalEdges(5,new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}});
    }
}
