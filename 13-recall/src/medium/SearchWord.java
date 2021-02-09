package medium;

/**
 *单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class SearchWord {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(chars[0] == board[i][j]){
                    if(dfs(board , i , j , chars , 1 , visited))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board , int i , int j ,char[] word , int idx , boolean[][] visited){
        if(idx == word.length)
            return true;
        visited[i][j] = true;
        boolean flag = false;
        if(!flag && i > 0 && !visited[i-1][j] && board[i-1][j] == word[idx])
            flag = dfs(board , i - 1 , j , word , idx + 1 , visited);
        if(!flag && i < board.length - 1 && !visited[i+1][j] && board[i+1][j] == word[idx])
            flag = dfs(board , i + 1 , j , word , idx + 1 , visited);
        if(!flag && j > 0 && !visited[i][j-1] && board[i][j-1] == word[idx])
            flag = dfs(board , i , j - 1 , word , idx + 1 , visited);
        if(!flag && j < board[0].length - 1 && !visited[i][j+1] && board[i][j+1] == word[idx])
            flag = dfs(board , i , j + 1 , word , idx + 1 , visited);
        visited[i][j] = false;
        return flag;
    }
}
