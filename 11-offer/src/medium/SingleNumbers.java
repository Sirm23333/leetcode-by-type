package medium;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum = sum ^ num;
        }
        // sum是所有num的异或值，等于两个结果数的异或值，如果sum的第x位为1，则说明这两个数的第x位一个是1一个是0
        // 所以可以用第x为区分，把第x位为0的分到一组，x位为1的分到一组
        int bit = 1;
        while( (sum & bit) == 0 ){
            bit = bit << 1;
        }
        int sumA = 0, sumB = 0;
        for(int num : nums){
            if( (num & bit) == 1){
                sumA ^= num;
            }else {
                sumB ^= num;
            }
        }
        return new int[]{sumA,sumB};
    }
}
