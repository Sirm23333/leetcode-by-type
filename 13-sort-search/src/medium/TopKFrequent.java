package medium;

import java.util.*;

/**
 *前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num , map.getOrDefault(num,0) + 1);
        Queue<Map.Entry> queue = new PriorityQueue<>(k, (o1, o2) -> (int)o2.getValue() - (int)o1.getValue());
        for(Map.Entry entry : map.entrySet())
            queue.offer(entry);
        int[] rs = new int[k];
        for(int i = 0; i < k; i++)
            rs[i] = (int)queue.poll().getKey();
        return rs;
    }
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num , map.getOrDefault(num,0) + 1);
        Queue<int[]> queue = new PriorityQueue<>( (o1, o2) -> o2[1] - o1[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] rs = new int[k];
        for(int i = 0; i < k; i++)
            rs[i] = queue.poll()[0];
        return rs;
    }
    /**
     * 从小到达排序  可以在插入时 优化堆排过程 O(logn)->O(logk)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num , map.getOrDefault(num,0) + 1);
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(queue.size() == k){
                if(queue.peek().getValue() < entry.getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }else {
                queue.offer(entry);
            }
        }
        int[] rs = new int[k];
        for(int i = 0; i < k; i++)
            rs[i] = queue.poll().getKey();
        return rs;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num , map.getOrDefault(num,0) + 1);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(queue.size() == k){
                if(queue.peek()[1] < entry.getValue()){
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }else {
                queue.offer(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        int[] rs = new int[k];
        for(int i = 0; i < k; i++)
            rs[i] = queue.poll()[0];
        return rs;
    }
}

