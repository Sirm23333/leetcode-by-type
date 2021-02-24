package medium;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class UniquePaths {
    /**
     * 递归 超时
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(m == 1)
            return 1;
        if(n == 1)
            return 1;
        return uniquePaths(m - 1,n) + uniquePaths(m,n-1);
    }

    /**
     * dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int[][] arr = new int[m][n];
        arr[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
