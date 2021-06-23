package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class MyPow {
    // 超时
    public double myPow(double x, int n) {
        int pow = Math.abs(n);
        double rs = 1.0;
        for(int i = 0; i < pow ; i++){
            rs *= x;
        }
        if(n < 0)
            rs = 1.0 / rs;
        return rs;
    }
    private static Map<Integer,Double> map = new HashMap<>();
    public static double myPow1(double x, int n) {
        int pow;
        double rs;
        if(n == Integer.MIN_VALUE){
            pow = Integer.MAX_VALUE;
            rs = myPow2(x,pow) * x;
        }else {
            pow = Math.abs(n);
            rs = myPow2(x,pow);
        }

        if(n < 0)
            rs = 1.0 / rs;
        return rs;
    }
    public static double myPow2(double x, int n) {
        if(n == 1)
            return x;
        if(n == 0)
            return 1;
        if(map.containsKey(n))
            return map.get(n);
        double rs = myPow2(x , n / 2) * myPow2(x , n / 2) * (n % 2 == 1 ? x : 1);
        map.put(n,rs);
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2.0,-2147483648));
    }
}
