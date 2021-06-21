package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumber {
    /**
     * 直接全排列，超时
     */
    String minStr;
    public String minNumber(int[] nums) {
        minNumber(nums,0);
        return minStr;
    }
    public void minNumber(int[] nums , int idx) {
        if(idx == nums.length - 1){
            StringBuffer sb = new StringBuffer();
            for(int num : nums){
                sb.append(num);
            }
            String tmp = sb.toString();
            if(minStr == null || minStr.compareTo(tmp) < 0){
                minStr = tmp;
            }
            return ;
        }
        for(int i = idx; i < nums.length; i++){
            {int tmp = nums[i]; nums[i] = nums[idx]; nums[idx] = tmp;}
            minNumber(nums,idx+1);
            {int tmp = nums[i]; nums[i] = nums[idx]; nums[idx] = tmp;}
        }
    }

    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (o1,o2)-> (o1 + o2).compareTo(o2 + o1));
        StringBuffer sb = new StringBuffer();
        for(String str :strs){
            sb.append(str);
        }
        return sb.toString();
    }

}
