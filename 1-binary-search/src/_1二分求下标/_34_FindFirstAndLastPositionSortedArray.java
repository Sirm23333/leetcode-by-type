package _1二分求下标;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _34_FindFirstAndLastPositionSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1)
            return new int[]{-1,-1};
        int left = binarySearchFirstPosition(nums, target);
        if(left == - 1 ){
            return new int[]{-1,-1};
        }
        int right = binarySearchLastPosition(nums,target);
        return new int[]{left,right};

    }
    // 查找第一个元素出现的位置，没有则返回-1
    public int binarySearchFirstPosition(int[] nums, int target){
        int start = 0 , end = nums.length - 1 , mid;
        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        // 此时start=end,且nums[start] <= target
        if(nums[start] == target)
            return start;
        else if(start < nums.length - 1 && nums[start + 1] == target)
            return  start + 1;
        return -1;
    }
    // 查找最后一个元素出现的位置，没有则返回-1
    public int binarySearchLastPosition(int[] nums, int target){
        int start = 0 , end = nums.length - 1 , mid;
        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        // 此时start=end,且nums[start] >= target
        if(nums[start] == target)
            return start;
        else if(start > 0 && nums[start - 1] == target)
            return  start - 1;
        return -1;
    }

}
