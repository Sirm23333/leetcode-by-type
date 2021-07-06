package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
// 数组中有负数，不能用双指针在O(n)实现
public class SubarraySum {
    /**
     * 前缀和
     * 定义pre[i]为 nums[0]..nums[i]的和
     * 则满足 pre[j] - pre[i] == k  i,j组数，即为答案
     */
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int pre = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0 , 1);
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            sum += map.getOrDefault(pre - k, 0);
            map.put(pre , map.getOrDefault(pre , 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{-1,-1,-1} , 0);
    }
}
