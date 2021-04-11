package medium;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int a = 0, b = 0, c = 0;
        for(int i = 1; i < n; i++){
            int a2 = arr[a] * 2;
            int b3 = arr[b] * 3;
            int c5 = arr[c] * 5;
            if(a2 < b3 && a2 < c5){
                arr[i] = a2;
                a++;
            }else if(b3 < c5){
                arr[i] = b3;
                b++;
            }else {
                arr[i] = c5;
                c++;
            }
            if(arr[i] == arr[i-1])
                i--;
        }
        return arr[n-1];
    }

    /**
     * 化简结果
     * @param n
     * @return
     */
    public static int nthUglyNumber2(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int a = 0, b = 0, c = 0;
        for(int i = 1; i < n; i++){
            int a2 = arr[a] * 2;
            int b3 = arr[b] * 3;
            int c5 = arr[c] * 5;
            arr[i] = Math.min(a2 , Math.min(b3,c5));
            if(arr[i] == a2) a++;
            if(arr[i] == b3) b++;
            if(arr[i] == c5) c++;
        }
        return arr[n-1];
    }
    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
