package medium;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class Jump {
    /**
     * dfs超时
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return dfs(nums,0);
    }
    public int dfs(int[] nums , int idx){
        if(idx == nums.length - 1)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++){
            if(idx + i < nums.length){
                int dfs = dfs(nums, idx + i);
                if(dfs != Integer.MAX_VALUE){
                    int step = 1 + dfs;
                    min = Math.min(min , step);
                }
            }
        }
        return min;
    }

    /**
     * dp O(n^2)
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(nums[j] >= i - j){
                    min = Math.min(min , dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }

    /**
     * 贪心 O(n)
     * 最多走len-1步可以到达最后
     * 走1步最远距离
     * 走2步最远距离
     * 走3步最远距离
     * ...
     * 比较好理解
     * @param nums
     * @return
     */
    public static int jump3(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return 0;
        int maxPos = 0, lastMaxPos = 0;
        for(int step = 1; step < nums.length - 1; step++){
            int max = 0;
            for(int i = lastMaxPos; i <= maxPos; i++){
                max = Math.max(max , i + nums[i]);
            }
            lastMaxPos = maxPos;
            maxPos = max;
            if(maxPos >= nums.length - 1)
                return step;
        }
        return nums.length - 1;
    }

    /**
     * 以jump3的思路继续做一步优化
     * @param nums
     * @return
     */
    public static int jump4(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        jump3(new int[]{1,2});
    }
}
