package easy;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {
    /**
     * 1   2   3   4
     * 5   6   7   8
     * 9   10  11  12
     * 13  14  15  16
     *
     * 00 01 02 03 13 23 33 32 31 30 20 10 11 12 22 21
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        int start = 0; // 当前遍历圈的行列的起始序号 (0,0)(1,1)...
        int row = matrix.length ;
        if(row == 0)
            return new int[0];
        int  col = matrix[0].length;
        int[] rs = new int[row * col];
        int k = 0;
        while(start <= (row - 1) / 2 && start <= (col - 1) / 2 ){
            int rowMaxIdx = row - start - 1;
            int colMaxIdx = col - start - 1;
            int i  , j ;
            // 向右
            for(i = start , j = start ;j <= colMaxIdx;j++)
                rs[k++] = matrix[i][j];
            if(rowMaxIdx == start) // 无法向下了
                break;
            // 向下
            for(i = start + 1, j = colMaxIdx ; i <= rowMaxIdx; i++)
                rs[k++] = matrix[i][j];
            // 向左
            for(i = rowMaxIdx, j = colMaxIdx - 1 ;j >= start; j--)
                rs[k++] = matrix[i][j];
            if(colMaxIdx == start) // 无法向上了
                break;
            // 向上
            for (i = rowMaxIdx - 1, j = start ;i > start; i--)
                rs[k++] = matrix[i][j];
            start++;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        spiralOrder(arr);
    }
}
