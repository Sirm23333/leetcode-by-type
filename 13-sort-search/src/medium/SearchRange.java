package medium;

/**
 *在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return new int[]{-1,-1};
        int left , right , first=-1 , second=-1;
        // 找第一个target
        left = 0;
        right = len - 1;
        while(left < right){
            first = left + (right - left) / 2;
            if(nums[first] < target)
                left = first + 1;
            else if(nums[first] >= target)
                right = first - 1;
        }
        if(nums[left] == target)
            first = left;
        else if(left < len - 1 && nums[left + 1] == target)
            first = left + 1;
        else
            return new int[]{-1,-1};
        // 找最后一个target
        left = first;
        right = len - 1;
        while(left < right){
            second = left + (right - left) / 2;
            if(nums[second] <= target)
                left = second + 1;
            else if(nums[second] > target)
                right = second - 1;
        }
        if(nums[right] == target)
            second = right;
        else if(right > 1 && nums[right - 1] == target)
            second = right - 1;
        return new int[]{first , second};
    }
}
