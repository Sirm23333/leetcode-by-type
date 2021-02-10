package easy;

/**
 *剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Exchange {
    /**
     * 直接交换，不考虑顺序
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(nums.length == 0)
            return nums;
        int i = 0 , j = 0 , tmp;
        while(i < nums.length && nums[i] % 2 == 1) i++;
        j = i;
        while(j < nums.length && nums[j] % 2 == 0) j++;
        while(j < nums.length){
            if(nums[j] % 2 == 1){
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
            j++;
        }
        return nums;
    }
}
