package medium;

/**
 *
 */
public class SearchMatrix {
    /**
     * dfs搜索
     * 超时
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix,0,0,target);
    }
    public boolean searchMatrix(int[][] matrix, int i, int j , int target ){
        if(i == matrix.length || j == matrix[0].length)
            return false;
        if(matrix[i][j] == target)
            return true;
        else if(matrix[i][j] > target)
            return false;
        return searchMatrix(matrix,i + 1,j,target) || searchMatrix(matrix,i,j+1,target);
    }

    /**
     * 线性搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target)
                    return true;
                if(matrix[i][j] > target)
                    break;
            }
        }
        return false;
    }
}
