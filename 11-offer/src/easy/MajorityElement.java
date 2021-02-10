package easy;

/**
 *剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0] , count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
                count++;
            }
            else if(num == candidate)
                count++;
            else {
                count--;
            }
        }
        return candidate;
    }
}
