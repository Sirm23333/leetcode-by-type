package easy;

/**
 *计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int sum = 0;
        boolean[] flag = new boolean[n+1]; // true代表合数
        for(int i = 1; i < n; i++){
            if(!flag[i] && isPrimes(i)){
                sum++;
                for(int j = i;  j < n ; j += i)
                    flag[j] = true;
            }
        }
        return sum;
    }
    boolean isPrimes(int n){
        if(n < 2)
            return false;
        int sq = (int) Math.sqrt(n) + 1;
        for(int i = 2; i < sq; i++ ){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes2(int n) {
        int sum = 0;
        boolean[] flag = new boolean[n+1]; // true代表合数
        for(int i = 2; i < n; i++){
            if(!flag[i]){
                sum++;
                for(int j = i;  j < n ; j += i)
                    flag[j] = true;
            }
        }
        return sum;
    }
}
