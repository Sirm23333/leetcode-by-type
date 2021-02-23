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
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(m == 1)
            return n - 1;
        if(n == 1)
            return m - 1;
        return uniquePaths(m - 1,n) + uniquePaths(m,n-1);
    }
}
