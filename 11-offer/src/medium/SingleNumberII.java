package medium;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for(int num : nums){
            int tmp = num;
            for(int i = 0; i < 32; i++){
                arr[i] += tmp & 1;
                tmp = tmp >>> 1;
            }
        }
        int rs = 0;
        for(int i = 0; i < 32; i++){
            if(arr[i] % 3 == 1){
                rs += Math.pow(2 , i);
            }
        }
        return rs;

    }
}
