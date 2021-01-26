package easy;

/**
 *
 */
public class ClimbStairs {
    /**
     * 递归 超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 递推
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n < 3)
            return n;
        int n1 = 1 , n2 = 2 , n3 = 0;
        for(int i = 0; i < n - 2; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

}
