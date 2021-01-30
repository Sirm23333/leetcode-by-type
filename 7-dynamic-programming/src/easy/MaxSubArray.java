package easy;

/**
 *
 */
public class MaxSubArray {
    /**
     * 二维dp
     * dp[i][0] 表示nums[i]不在子序列中
     * dp[i][1] 表示nums[i]在子序列中
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 如果全是负数，则最大值为答案
        int max = Integer.MIN_VALUE;
        boolean flag = true;
        for(int num : nums){
            if(num > 0){
                flag = false;
                break;
            }
            max = Math.max(max , num);
        }
        if(flag)
            return max;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i] , nums[i]);
        }
        return Math.max(dp[len - 1][0] , dp[len - 1][1]);
    }

    /**
     * 一维dp  dp[i] 表示以nums[i]结尾的子序列的最大和
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < len; i++){
            if(dp[i - 1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = dp[i - 1] + nums[i];
            max = Math.max(max , dp[i]);
        }
        return max;
    }

    /**
     * maxSubArray2的优化，节约空间
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        int cur = nums[0]; // 当前遍历到的以Nums[i]结尾的子序列的最大和
        int max = cur; // 历史最大和
        for(int i = 1; i < len; i++){
            if(cur < 0)
                cur = nums[i];
            else
                cur += nums[i];
            max = Math.max(max , cur);
        }
        return max;
    }



}
