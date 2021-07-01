package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSwapsCouples {
    public int minSwapsCouples(int[] row) {
        UnionSet unionSet = new UnionSet(row.length / 2);
        Map<Integer,Integer> noToIdx = new HashMap<>();
        for(int i = 0; i < row.length; i++){
            noToIdx.put(row[i] , i / 2);
        }
        for(int i = 0; i < row.length; i++){
            Integer me = noToIdx.get(row[i]);
            Integer ta = noToIdx.get(row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1);
            unionSet.union(me,ta);
        }
        int cnt = 0;
        for(int i = 0; i < unionSet.parent.length; i++){
            if(unionSet.parent[i] == i)
                cnt += unionSet.count[i] - 1;
        }
        return cnt;
    }
    class UnionSet{
        int[] parent;
        int[] rank;
        int[] count; // count[i]表示以i为根节点的树的节点数量
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
            count = new int[len];
            for(int i = 0; i < len; i++){
                parent[i] = i;
                rank[i] = i;
                count[i] = 1;
            }
        }
        public int find(int i){
            if(parent[i] == i)
                return i;
            int root = find(parent[i]);
            if(root != parent[i]){
                count[parent[i]] -= count[i];
                parent[i] = root;
            }
            return parent[i];
        }
        public void union(int i , int j){
            int pi = find(i);
            int pj = find(j);
            if(pi != pj){
                int cnt = count[pi] + count[pj];
                if(rank[pi] < rank[pj]){
                    parent[pi] = pj;
                    count[pj] = cnt;
                }else if(rank[pi] > rank[pj]){
                    parent[pj] = pi;
                    count[pi] = cnt;
                }else {
                    parent[pi] = pj;
                    count[pj] = cnt;
                    rank[pj]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinSwapsCouples minSwapsCouples = new MinSwapsCouples();
        minSwapsCouples.minSwapsCouples(new int[]{0,2,1,3});
    }
}
