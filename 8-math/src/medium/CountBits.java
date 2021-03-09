package medium;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class CountBits {
    public int[] countBits(int num) {
        if(num == 0)
            return new int[]{0};
        if(num == 1)
            return new int[]{0,1};
        int[] rs = new int[num+1];
        rs[0] = 0;
        rs[1] = 1;
        for(int i = 2; i <= num; i++){
            if(i % 2 == 1){
                rs[i] = rs[i-1] + 1;
            }else {
                rs[i] = rs[((i-1)/2)  + 1];
            }
        }
        return rs;
    }
}
