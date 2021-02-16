package medium;

/**
 *搜索旋转排序数组
 *
 */
public class RotateArray {
    /**
     * 线性搜索
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            if(nums[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return -1;
        // 先二分找到最小值的位置
        int left = 0, right = len - 1, idx = -1;
        if(nums[0] <= nums[len-1]){
            idx = 0;
        }else {
            while(left < right){
                idx = left + (right - left) / 2;
                if(nums[idx] >= nums[0]){
                    left = idx + 1;
                }else {
                    right = idx;
                }
            }
            idx = left;
        }
        // 找target
        if(idx == 0){
            left = 0;
            right = len - 1;
        }else if(target >= nums[0]){
            left = 0;
            right = idx;
        }else {
            left = idx;
            right = len -1;
        }
        int mid;
        while(left < right){
            mid = left + (right - left ) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return nums[left] == target ? left : -1;
    }
}
