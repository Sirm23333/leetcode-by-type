package easy;

/**
 *
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




}
