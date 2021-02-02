package easy;

import java.util.Arrays;

/**
 *缺失数字
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 */
public class MissingNumber {
    /**
     * 先排序
     * O(nlogn)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }

    /**
     * 用一个数组记录数字是否存在，flag[i]为true时表示存在i
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {

        boolean[] flag = new boolean[nums.length + 1];
        for(int num : nums)
            flag[num] = true;
        for(int i = 0; i < flag.length; i++){
            if(!flag[i])
                return i;
        }
        return 0;
    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length + 1;
        int tmp = 0;
        for(int i = 0; i < n; i++)
            tmp ^= i;
        for(int num : nums)
            tmp ^= num;
        return tmp;
    }


}
