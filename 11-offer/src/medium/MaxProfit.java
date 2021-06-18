package medium;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 剑指 Offer 63. 股票的最大利润(只买卖一次)
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class MaxProfit {
    /**
     * 记录每一段的最小值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int max = 0;
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i-1] , prices[i]);
            max = Math.max(max,prices[i] - min[i-1]);
        }
        return max ;
    }

    /**
     * dp
     * dp[i][0]表示第i天，手里没有股票情况下的最大收益
     * dp[i][1]表示第i天，手里有股票情况下的最大收益
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] );
        }
        return dp[len-1][0];
    }
}
