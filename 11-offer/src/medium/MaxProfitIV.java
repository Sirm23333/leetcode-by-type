package medium;

/**
 * 188. 买卖股票的最佳时机 IV(买卖k次)
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitIV {
    /**
     * dp[i][0][k] 第i天，手里没有股票，完成k次交易的情况下的最大收益
     * dp[i][1][k] 第i天，手里有股票，完成k次交易的情况下的最大收益
     * @param prices
     * @return
     */
    public int maxProfit(int k,int[] prices) {
        int len = prices.length;
        if(len == 0 || k == 0) return 0;
        // 每一天结束，共会有2k+1中可能的状态，即 没有买过、买过1次没有卖过、买过1次卖过1次、买过2次卖过1次....
        int[][] dp = new int[len][2*k+1];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 2; i < 2 * k + 1; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }
        for(int i = 1; i < len; i++){
            dp[i][0] = 0;
            for(int j = 1; j < 2 * k + 1; j+=2){
                dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i-1][j-1] - prices[i]);
                dp[i][j+1] = Math.max(dp[i-1][j+1] , dp[i-1][j] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i-1][j] + prices[i]);
            }
        }
        int max = 0;
        for(int i = 0; i < 2 * k + 1; i+=2){
            max = Math.max(dp[len-1][i],max);
        }
        return max;
    }


}
