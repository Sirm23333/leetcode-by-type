package ali.gaode.first;

/**
 * 一个m*n的二维数组，斜向遍历每个元素，例如：
 * 1,2,3,4
 * 5,6,7,8
 * a,b,c,d
 * 遍历结果 1 2 5 3 6 a 4 7 b 8 c d
 */
public class ArrayIter {
    public static void main(String[] args) {
        char[][] arr = new char[][] {{'1','2','3','4'},{'5','6','7','8'},{'a','b','c','d'}};

        int m = arr.length;
        if(m < 1) return;
        int n = arr[0].length;
        for(int i = 0; i <= n + m - 2; i++){
            for(int j = 0; j < m && j <= i; j++){
                if(i - j < n){
                    System.out.print(arr[j][i-j] + " ");
                }
            }
        }
    }
}
