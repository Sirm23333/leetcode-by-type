package easy;

import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n×n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RotateImg {

    /**
     * 先上下翻转 再镜像翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2)
            return;
        int tmp;
        // 上下翻转
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i -1 ][j] = tmp;
            }
        }
        // 对角线镜像翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    /**
     * 按照第一种思路，可以化为一步
     * (i,j)->(n-i-1,j)->(j,n-i-1)
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        if (n < 2)
            return;
        int[][] tmpMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            tmpMatrix[i] = Arrays.copyOf(matrix[i],n);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++){
                matrix[j][n-i-1] = tmpMatrix[i][j];
            }
        }
    }

}
