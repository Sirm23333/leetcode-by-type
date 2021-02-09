package medium;

/**
 *岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m < 1)
            return 0;
        int n = grid[0].length;
        if(n < 1)
            return 0;
        int num = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,visited);
                    num++;
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid , int i , int j , boolean[][] visit){
        visit[i][j] = true;
        if(i > 0 && grid[i-1][j] == '1' && !visit[i-1][j])
            dfs(grid , i - 1 , j , visit);
        if(i < grid.length - 1 && grid[i+1][j] == '1' && !visit[i+1][j])
            dfs(grid , i + 1 , j , visit);
        if(j > 0 && grid[i][j-1] == '1' && !visit[i][j-1])
            dfs(grid , i  , j - 1 , visit);
        if(j < grid[0].length - 1 && grid[i][j+1] == '1' && !visit[i][j+1])
            dfs(grid , i , j + 1 , visit);
    }


}
