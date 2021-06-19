package medium;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class ConstructArr {
    /**
     * 直接暴力  O(n^2)
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for(int i = 0; i < b.length; i++){
            int con = 1;
            for(int j = 0; j < a.length; j++){
                if(i != j) con *= a[j];
            }
            b[i] = con;
        }
        return b;
    }

    /**
     * b0   1   a1  a2  a3  a4
     * b1   a0  1   a2  a3  a4
     * b2   a0  a1  1   a3  a4
     * b3   a0  a1  a2  1   a4
     * b4   a0  a1  a2  a3  1
     * @param a
     * @return
     */
    public int[] constructArr2(int[] a) {
        int[] b = new int[a.length];
        int leftCon = 1 , rightCon = 1;
        for(int i = 0; i < b.length; i++){
            if(i > 0)
                leftCon *= a[i-1];
            b[i] = leftCon;
        }
        for(int i = b.length - 1; i >= 0; i--){
            if(i < b.length - 1)
                rightCon *= a[i + 1];
            b[i] *= rightCon;
        }
        return b;
    }
}
