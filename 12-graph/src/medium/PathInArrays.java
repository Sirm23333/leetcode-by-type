package medium;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 */
public class PathInArrays {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board,i,j,visited,chars,0))
                    return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int x, int y, boolean[][] visited , char[] word, int idx){
        if(word.length - 1 == idx && board[x][y] == word[idx])
            return true;
        else if(board[x][y] != word[idx])
            return false;

        visited[x][y] = true;
        if(x > 0 && !visited[x-1][y] && exist(board,x-1,y,visited,word,idx+1))
            return true;
        if(x < board.length - 1 && !visited[x+1][y] && exist(board,x+1,y,visited,word,idx+1))
            return true;
        if(y > 0 && !visited[x][y-1] && exist(board,x,y-1,visited,word,idx+1))
            return true;
        if(y < board[0].length - 1 && !visited[x][y+1] && exist(board,x,y+1,visited,word,idx+1))
            return true;
        visited[x][y] = false;
        return false;
    }

}
