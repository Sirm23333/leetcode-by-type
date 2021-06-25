package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        int[] rs = new int[nums.length - k + 1];
        int left = 0 , right = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while(right < k){
            while(!queue.isEmpty() && queue.peekLast() < nums[right])
                queue.pollLast();
            queue.addLast(nums[right]);
            right++;
        }
        int idx = 0;
        right = k;
        rs[idx++] = queue.peekFirst();
        while(right < nums.length){
            while(!queue.isEmpty() && queue.peekLast() < nums[right])
                queue.pollLast();
            queue.addLast(nums[right]);
            right++;
            if(queue.peekFirst().equals(nums[left]))
                queue.pollFirst();
            left++;
            rs[idx++] = queue.peekFirst();
        }
        return rs;
    }
}
