package medium;

/**
 *递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvvuqg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IncreasingTriplet {
    /**
     * 暴力法
     * O(n^3)
     * 超时
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                for(int k = j + 1; k < len; k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * 记录最小值和次小值
     * O(n)
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= first)
                first = num;
            else if(num <= second)
                second = num;
            else
                return true;
        }
        return false;
    }
}
