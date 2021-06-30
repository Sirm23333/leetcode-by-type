package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javafx.scene.input.KeyCode.H;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * 通过次数134,358提交次数249,362
 */
public class LongestConsecutive {
    int[] parent;
    int[] rank;
    int[] count; // 每个节点为根的树的节点数量
    int max = 1;
    private void init(int len){
        parent = new int[len];
        rank = new int[len];
        count = new int[len];
        for(int i = 0; i < len; i++){
            parent[i] = i;
            rank[i] = 1;
            count[i] = 1;
        }
    }
    // 压缩路径
    private int find(int i){
        if(parent[i] == i)
            return i;
        int p = find(parent[i]);
        if(p != parent[i]){
            count[parent[i]]--;
            parent[i] = p;
        }
        return parent[i];
    }
    // 按秩合并
    private void union(int i, int j){
        int pi = find(i);
        int pj = find(j);
        if(pi != pj){
            if(rank[pi] > rank[pj]){
                parent[pj] = pi;
                count[pi] +=  count[pj];
                max = Math.max(max,count[pi]);
            }else if(rank[pi] < rank[pj]){
                parent[pi] = pj;
                count[pj] += count[pi];
                max = Math.max(max,count[pj]);
            }else {
                parent[pi] = pj;
                rank[pj]++;
                count[pj] += count[pi];
                max = Math.max(max,count[pj]);
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if(length < 2)
            return length;
        init(length);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , i);
                if(map.containsKey(nums[i] - 1)){
                    union(i , map.get(nums[i] - 1));
                }
                if(map.containsKey(nums[i] + 1)){
                    union(i , map.get(nums[i] + 1));
                }
            }
        }
        return max;
    }

    /**
     * 解法2，直接利用Set更容易
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        int length = nums.length;
        if(length < 2)
            return length;
        int curLen ;
        int curValue;
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
          set.add(num);
        for(int num : set){
            if(!set.contains(num - 1)){
                curLen = 1;
                curValue = num;
                while(set.contains(curValue + 1)){
                    curValue++;
                    curLen++;
                }
                maxLen = Math.max(maxLen , curLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        longestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2});

    }
}
