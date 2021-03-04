package medium;

import java.util.Arrays;

/**
 *300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class LengthOfLIS {
    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] length = new int[len];
        Arrays.fill(length,1);
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(nums[j] > nums[i]){
                    length[j] = Math.max(length[j] , length[i] + 1);
                }
            }
        }
        int max = -1;
        for(int l : length)
            max = Math.max(l,max);
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[1] = nums[0];
        int length = 1;
        for(int i = 1;i < len; i++){
            if(nums[i] > dp[length]){
                dp[++length] = nums[i];
            }else {
                int idx = search(dp, 1, length,nums[i]);
                dp[idx] = nums[i];
            }
        }
        return length;
    }
    /**
     * 选择第一个大于num的坐标
     * @param dp
     * @param start
     * @param end
     * @return
     */
    public int search(int[] dp , int start, int end , int num){
        int left = start ,right = end, mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(dp[mid] < num){
                left = mid + 1;
            }else if(dp[mid] > num){
                right = mid;
            }else {
                return mid;
            }
        }
        return left;
    }

}
