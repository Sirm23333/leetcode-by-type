package medium;

import java.util.Stack;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValue {
    /**
     * 递归超时
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        return maxValue(grid,0,0);
    }
    public int maxValue(int[][] grid , int i , int j) {
        if(i >= grid.length || j >= grid[0].length)
            return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        return grid[i][j] + Math.max(maxValue(grid , i + 1, j) , maxValue(grid, i , j + 1));
    }

    /**
     * 非递归dfs超时
     * @param grid
     * @return
     */
    public static int maxValue2(int[][] grid) {
        int imax = grid.length - 1;
        int jmax = grid[0].length- 1;
        Stack<int[]> step = new Stack<>();
        Stack<Integer> value = new Stack<>();
        int max = 0;
        step.push(new int[]{0,0});
        value.push(grid[0][0]);
        while(!step.isEmpty()){
            int[] pop = step.pop();
            Integer v = value.pop();
            if(pop[0] < imax){
                step.push(new int[]{pop[0] + 1,pop[1]});
                value.push(v + grid[pop[0] + 1][pop[1]]);
            }
            if(pop[1] < jmax){
                step.push(new int[]{pop[0],pop[1] + 1});
                value.push(v + grid[pop[0]][pop[1] + 1]);
            }
            if(pop[0] + pop[1] == imax + jmax){
                max = Math.max(max,v);
            }
        }
        return max;
    }

    /**
     * dp
     * @param grid
     * @return
     */
    public static int maxValue3(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = grid[i][j] + Math.max(i > 0 ? dp[i - 1][j] : 0 , j > 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[m-1][n-1];
    }
}
