package medium;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MovingCount {
    static boolean[][] visited ;
    static int m,n;
    public static int movingCount(int a, int b, int k) {
        visited = new boolean[a][b];
        m = a;
        n = b;
        dfs(0,0,k);
        int sum = 0;
        for(boolean[] row : visited){
            for(boolean flag : row){
                if(flag)
                    sum++;
            }
        }
        return sum;
    }
    private static void dfs(int a, int b, int k ){
        visited[a][b] = true;
        if( a + 1 < m && !visited[a+1][b] &&  bAdd(a + 1, b) <= k)
            dfs(a+1,b,k);
        if( a > 0 && !visited[a-1][b] && bAdd(a - 1 , b) <= k)
            dfs(a - 1 , b , k);
        if( b + 1 < n && !visited[a][b + 1] && bAdd(a , b + 1) <= k)
            dfs(a , b + 1, k);
        if(b - 1 > 0 && !visited[a][b - 1] && bAdd(a , b - 1) <= k)
            dfs(a , b - 1, k);
    }
    private static int bAdd(int a, int b){
        int sum = 0;
        while(a != 0){
            sum += a % 10;
            a /= 10;
        }
        while(b != 0){
            sum += b % 10;
            b /= 10;
        }
        return sum;
    }


}
