package medium;

/**
 * 剑指 Offer 14- II. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class CuttingRopeII {
    public int cuttingRope(int n) {
        if(n == 1 || n == 2)
            return 1;
        if(n == 3)
            return 2;
        int count = n / 3;
        int re = n % 3;
        if(re == 0)
            return pow3(count);
        else if(re == 1)
            return pow3(count - 1) * 2 % 1000000007 * 2 % 1000000007;
        else
            return pow3(count) * 2 % 1000000007;
    }
    private int pow3(int a){
        int rs = 1;
        for(int i = 0; i < a; i++){
            int tmp = rs;
            for(int j = 0; j < 2; j++){
                rs = (rs + tmp) % 1000000007;
            }
        }
        return rs;
    }
    // 大数取余
    // (xy)⊙p=[(x⊙p)(y⊙p)]⊙p
    private static int pow(int x , int a){
        int p = 1000000007;
        if(a % 2 == 1)
            return (x * (int)Math.pow(x * x % p, a/2)) % p;
        return (int)Math.pow(x * x % p, a/2) % p;
    }

}
