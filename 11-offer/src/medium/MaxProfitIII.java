package medium;

import java.util.Arrays;

/**
 * 123. 买卖股票的最佳时机 III(只买卖2次)
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitIII {
    /**
     * dp[i][0][k] 第i天，手里没有股票，完成k次交易的情况下的最大收益
     * dp[i][1][k] 第i天，手里有股票，完成k次交易的情况下的最大收益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int MIN_VALUE = Integer.MIN_VALUE;
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = MIN_VALUE;
        dp[0][0][2] = MIN_VALUE;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = MIN_VALUE;
        dp[0][1][2] = MIN_VALUE;
        for(int i = 1; i < len; i++){
            dp[i][0][0] = dp[i-1][0][0];
            dp[i][0][1] = Math.max(dp[i-1][0][1] , dp[i-1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2] , dp[i-1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][0][0] == MIN_VALUE ? MIN_VALUE : - prices[i] , dp[i-1][1][0]);
            dp[i][1][1] = Math.max(dp[i-1][1][1] , dp[i-1][0][1] == MIN_VALUE ? MIN_VALUE : dp[i-1][0][1] - prices[i]);
            dp[i][1][2] = MIN_VALUE;
        }
        return Math.max(dp[len-1][0][0] , Math.max(dp[len-1][0][1] , dp[len-1][0][2]));
    }

    /**
     * 改用二维数组
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;
        dp[0][3] = Integer.MIN_VALUE;
        dp[0][4] = Integer.MIN_VALUE;
        for(int i = 1; i <len; i++){
            dp[i][0] = 0; // 第i天结束，没买过股票
            dp[i][1] = Math.max(dp[i-1][1] , -prices[i]); // 第i天结束，买过一次
            dp[i][2] = Math.max(dp[i-1][2] , dp[i-1][1] + prices[i]); // 第i天结束，买卖过一次
            dp[i][3] = Math.max(dp[i-1][3] , dp[i-1][2] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i-1][2] - prices[i]); // 第i天结束，买过两次，卖过一次
            dp[i][4] = Math.max(dp[i-1][4] , dp[i-1][3] + prices[i]); // 第i天结束，买卖过两次
        }
        return Math.max(dp[len-1][0] , Math.max(dp[len-1][2] , dp[len-1][4]));
    }

}
