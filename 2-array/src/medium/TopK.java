package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class TopK {

    /**
     * 排序 O(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[k-1];
    }

    private static void quickSort(int[] nums, int left, int right){
        if(left > right)
            return;
        int tmp = nums[left];
        int i = left, j = right;
        while (i < j){
            while(i < j && nums[j] <= tmp) j--;
            if(i < j)
                nums[i] = nums[j];
            while(i < j && nums[i] >= tmp) i++;
            if(i < j)
                nums[j] = nums[i];
        }
        nums[i] = tmp;
        quickSort(nums , left , i - 1);
        quickSort(nums, i + 1, right);
    }

    /**
     * 容量为k的小项堆
     * O(nlogk)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if(queue.size() > k)
                queue.poll();
        }
        return queue.poll();
    }


}
