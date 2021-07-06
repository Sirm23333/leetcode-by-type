package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        // key:1的数量-0的数量 value:最小位置
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rs = 0;
        int pre = 0;
        for(int i = 0; i < nums.length; i++){
            pre += (nums[i] == 1 ? 1 : -1);
            if(!map.containsKey(pre)){
                map.put(pre,i);
            }
            if(map.containsKey(-pre)){
                rs = Math.max(rs , i - map.get(-pre));
            }
        }
        return rs;
    }
}
