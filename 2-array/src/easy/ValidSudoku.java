package easy;

/**
 * 有效的数独
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ValidSudoku {
    /**
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] flag = new boolean[3][9][9];
        int tmp;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                tmp = board[i][j] - '1';
                if(flag[0][i][tmp] || flag[1][j][tmp] || flag[2][ (i / 3) * 3 + (j / 3)  ][tmp]){
                    return false;
                }else {
                    flag[0][i][tmp] = true;
                    flag[1][j][tmp] = true;
                    flag[2][ (i / 3) * 3 + (j / 3)  ][tmp] = true;
                }
            }
        }
        return true;
    }
}
