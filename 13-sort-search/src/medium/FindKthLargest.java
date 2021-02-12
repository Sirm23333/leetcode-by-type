package medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            if(queue.size() == k){
                if(queue.peek() < num){
                    queue.poll();
                    queue.offer(num);
                }
            }else {
                queue.offer(num);
            }
        }
        return queue.peek();
    }
}
