package easy;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RotateArray {


    /**
     * 方法一
     * 把后k个移到前面
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] newNums = new int[len];

        System.arraycopy(nums , len - k , newNums , 0 , k);
        System.arraycopy(nums , 0 , newNums , k , len - k);
        System.arraycopy(newNums , 0 , nums , 0 , len);
    }

    /**
     * 方法二
     * 翻转 空间复杂度O(1)
     * @param nums
     * @param start
     * @param end
     */
    private static void reverse(int[] nums , int start , int end){
        int tmp;
        while(start < end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums , 0 , len - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , len - 1);
    }

    /**
     * 方法三
     * 直接移动
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int tmp = nums[0] , tTmp , startIdx = 0 , idx = 0;
        for(int i = 0; i < len; i++){
            tTmp = nums[(idx + k) % len];
            nums[(idx + k) % len] = tmp;
            tmp = tTmp;
            idx = (idx + k) % len;
            if(idx == startIdx){
                idx = (idx + 1) % len;
                startIdx = idx;
                tmp = nums[idx];
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate3(nums,k);
    }
}
