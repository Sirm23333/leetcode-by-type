package medium;

/**
 *
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 */
public class FindPeakElement {
    /**
     * 线性查找
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        int first, second, third ;
        for(int i = 0; i < len; i++){
            first = i == 0 ? Integer.MIN_VALUE : nums[i-1];
            second = nums[i];
            third = i == len - 1 ? Integer.MIN_VALUE : nums[i+1];
            if(first < second && second > third)
                return i;
        }
        return -1;
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        int left = 0 , right = len - 1 , mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if( (mid == 0 || nums[mid] > nums[mid - 1]) && (mid == len - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if(mid == 0 || nums[mid] > nums[mid - 1])
                left = mid + 1;
            else if(mid == len - 1 || nums[mid] > nums[mid + 1])
                right = mid - 1;
            else
                right = mid - 1; // 下峰值
        }
        return left == 0 ? left : right;
    }
}
