package medium;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m < 1)
            return 0;
        int n = matrix[0].length;
        if(n < 1)
            return 0;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max , dp[i][0]);
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max , dp[0][j]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = matrix[i][j] == '0' ? 0 : (1 + Math.min(Math.min(dp[i-1][j] , dp[i][j-1]) , dp[i-1][j-1]));
                max = Math.max(max , dp[i][j]);
            }
        }
        return max * max;
    }
}
