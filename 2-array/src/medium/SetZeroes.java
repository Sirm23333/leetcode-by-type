package medium;

/**
 *矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 */
public class SetZeroes {

    /**
     * 空间复杂度为O(m+n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m < 1)
            return;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            if(rows[i]){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < n; j++){
            if(cols[j]){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**
     * 不用额外的两个数s组，而是用matrix[0][j]和matrix[i][0]记录
     * 空间复杂度为O(1)
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        if(m < 1)
            return;
        int n = matrix[0].length;
        boolean flag1 = false , flag2 = false;
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                flag1 = true;
                break;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                flag2 = true;
                break;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(flag1){
            for(int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        if(flag2){
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }

}
