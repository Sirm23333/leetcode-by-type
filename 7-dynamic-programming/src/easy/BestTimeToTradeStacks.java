package easy;

/**
 *买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BestTimeToTradeStacks {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                max = Math.max(max , prices[j] - prices[i]);
            }
        }
        return max < 0 ? 0 : max;
    }

    /**
     * 记录每一段的最小值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = Integer.MIN_VALUE;
        int[] mins = new int[prices.length];
        mins[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            max = Math.max(max , prices[i] - mins[i - 1]);
            mins[i] = Math.min(mins[i - 1] , prices[i]);
        }
        return max < 0 ? 0 : max;
    }

    /**
     * 记录历史最小值，不用数组
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            max = Math.max(max , prices[i] - min);
            min = Math.min(min , prices[i]);
        }
        return max < 0 ? 0 : max;
    }

    /**
     * dp
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] ,  - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * dp 节省空间
     * @param prices
     * @return
     */
    public int maxProfit5(int[] prices) {
        int len = prices.length;
        int pre0 = 0,pre1 = -prices[0],dp0 = 0, dp1;
        for(int i = 1; i < len; i++){
            dp0 = Math.max(pre0 , pre1 + prices[i]);
            dp1 = Math.max(pre1 , - prices[i]);
            pre0 = dp0;
            pre1 = dp1;
        }
        return dp0;
    }
}
