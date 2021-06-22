package medium;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 */
public class DicesProbability {
    public static double[] dicesProbability(int n) {
        int min = n ;
        int max = n * 6;
        int total = (int) Math.pow(6,n);
        double[] rs = new double[max - min + 1];
        int[][] dp = new int[n + 1][max + 1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        for(int i = 2; i < n + 1; i++){
            for(int j = 1; j < max + 1; j++){
                dp[i][j] = dp[i-1][j-1] +
                        (j >= 2 ? dp[i-1][j-2] : 0) +
                        (j >= 3 ? dp[i-1][j-3] : 0) +
                        (j >= 4 ? dp[i-1][j-4] : 0) +
                        (j >= 5 ? dp[i-1][j-5] : 0) +
                        (j >= 6 ? dp[i-1][j-6] : 0);
            }
        }
        for(int i = 0; i < max - min + 1; i++){
            rs[i] = (double)dp[n][min + i] / total;
        }
        return rs;
    }

    public static void main(String[] args) {
        dicesProbability(2);
    }
}
